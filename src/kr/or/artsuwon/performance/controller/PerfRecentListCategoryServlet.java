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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PerfRecentListCategoryServlet
 */
@WebServlet("/performance/recentByCategory.do")
public class PerfRecentListCategoryServlet extends HttpServlet {
	/// FIELDs
	private static final long serialVersionUID = 1L;
	private PerformanceService service = new PerformanceServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfRecentListCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Parameters
		String category = NullChecker.NullCheckString(request.getParameter("category"), "None");
		PerfCategory perfCategory = PerfCategory.valueOf(category.toUpperCase());

		// Business Logic
		ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> list = service.getRecentPerformances(perfCategory);

		JSONArray array = new JSONArray();
		for (Tuple<PerformanceSchedule, PerformanceInfomation> tuple : list) {
			JSONObject json = new JSONObject();
			json.put("perf_no", tuple.getFirst().getPerformanceNo());							// 공연번호
			json.put("schedule_no", tuple.getFirst().getScheduleNo());							// 스케줄번호
			json.put("location", tuple.getFirst().getLocation());								// 공연장소
			json.put("day", DateConverter.convertSQLDateToString(tuple.getFirst().getPerformanceDate(), "MM.dd"));			// 공연일자
			json.put("weekday", DateConverter.convertSQLDateToString(tuple.getFirst().getPerformanceDate(), "EEE요일"));		// 공연요일
			json.put("time", DateConverter.convertSQLDateToString(tuple.getFirst().getPerformanceDate(), "HH:mm"));			// 공연시간
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
