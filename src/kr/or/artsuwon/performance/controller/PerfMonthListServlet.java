package kr.or.artsuwon.performance.controller;

import kr.or.artsuwon.common.DateConverter;
import kr.or.artsuwon.common.NullChecker;
import kr.or.artsuwon.common.Tuple;
import kr.or.artsuwon.performance.model.common.PerfCategory;
import kr.or.artsuwon.performance.model.service.PerformanceService;
import kr.or.artsuwon.performance.model.service.PerformanceServiceImpl;
import kr.or.artsuwon.performance.model.vo.PerformanceInfomation;
import kr.or.artsuwon.performance.model.vo.PerformanceSchedule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PerfMonthListServlet
 */
@WebServlet("/performance/monthList.do")
public class PerfMonthListServlet extends HttpServlet {
	/// FIELDs
	private static final long serialVersionUID = 1L;
	private PerformanceService service = new PerformanceServiceImpl();
	private final SimpleDateFormat dayFormat = new SimpleDateFormat("MM.dd");			// 날짜 출력 포멧
	private final SimpleDateFormat weekdayFormat = new SimpleDateFormat("EEE요일");		// 요일 출력 포멧
	private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");			// 시간 출력 포멧
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfMonthListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get Date
		Calendar now = Calendar.getInstance();

		// Parameters
		int year = NullChecker.NullCheckParseInt(request.getParameter("year"), now.get(Calendar.YEAR));
		int month = NullChecker.NullCheckParseInt(request.getParameter("month"), now.get(Calendar.MONTH) + 1);
		Date date = DateConverter.convertStringToDate(String.format("%04d-%02d-01", year, month), "yyyy-MM-dd");		// 1일로 고정

		// Business Logic
		ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> list = service.getRecentPerformancesByMonth(date);

		JSONArray array = new JSONArray();
		for (Tuple<PerformanceSchedule, PerformanceInfomation> tuple : list) {
			JSONObject json = new JSONObject();
			json.put("perf_no", tuple.getFirst().getPerformanceNo());							// 공연번호
			json.put("schedule_no", tuple.getFirst().getScheduleNo());							// 스케줄번호
			json.put("location", tuple.getFirst().getLocation());								// 공연장소
			json.put("day", dayFormat.format(tuple.getFirst().getPerformnaceDate()));			// 공연일자
			json.put("weekday", weekdayFormat.format(tuple.getFirst().getPerformnaceDate()));	// 공연요일
			json.put("time", timeFormat.format(tuple.getFirst().getPerformnaceDate()));			// 공연시간
			json.put("photo", NullChecker.NullCheckString(tuple.getSecond().getPhoto()));		// 공연사진
			json.put("category", tuple.getSecond().getCategory());								// 공연카테고리
			json.put("title", tuple.getSecond().getTitle());									// 공연제목
			json.put("conductor", tuple.getSecond().getConductor());							// 지휘자
			json.put("collaborator", tuple.getSecond().getCollaborator());						// 협연자
			json.put("program", tuple.getSecond().getPrograms());								// 프로그램
			json.put("price", tuple.getFirst().getPrice());										// 공연가격

			array.add(json);
		}

		// View
		response.setCharacterEncoding(StandardCharsets.UTF_8.toString());						// Encoding
		response.setContentType("application/json");											// Content Type
		PrintWriter out = response.getWriter();
		out.print(array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
