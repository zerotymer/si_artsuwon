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
		Date date = DateConverter.convertStringToDate(String.format("%04d-%02d-01", year, month), "yyyy-MM-dd");		// 1?????? ??????

		// Business Logic
		ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> list = service.getRecentPerformancesByMonth(date);

		JSONArray array = new JSONArray();
		for (Tuple<PerformanceSchedule, PerformanceInfomation> tuple : list) {
			JSONObject json = new JSONObject();
			json.put("perf_no", tuple.getFirst().getPerformanceNo());							// ????????????
			json.put("schedule_no", tuple.getFirst().getScheduleNo());							// ???????????????
			json.put("location", tuple.getFirst().getLocation());								// ????????????
			json.put("day", DateConverter.convertSQLDateToString(tuple.getFirst().getPerformanceDate(), "MM.dd"));			// ????????????
			json.put("weekday", DateConverter.convertSQLDateToString(tuple.getFirst().getPerformanceDate(), "EEE??????"));		// ????????????
			json.put("time", DateConverter.convertSQLDateToString(tuple.getFirst().getPerformanceDate(), "HH:mm"));			// ????????????
			json.put("photo", NullChecker.NullCheckString(tuple.getSecond().getPhoto()));		// ????????????
			json.put("category", tuple.getSecond().getCategory());								// ??????????????????
			json.put("title", tuple.getSecond().getTitle());									// ????????????
			json.put("conductor", tuple.getSecond().getConductor());							// ?????????
			json.put("collaborator", tuple.getSecond().getCollaborator());						// ?????????
			json.put("program", tuple.getSecond().getPrograms());								// ????????????
			json.put("price", tuple.getFirst().getPrice());										// ????????????

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
