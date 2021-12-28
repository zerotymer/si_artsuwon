package kr.or.artsuwon.performance.controller;

import kr.or.artsuwon.common.NullChecker;
import kr.or.artsuwon.common.Tuple;
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
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PerfRecentList
 */
@WebServlet("/performance/recentList.do")
public class PerfRecentListServlet extends HttpServlet {
	/// FIELDs
	private static final long serialVersionUID = 1L;
	private PerformanceService service = new PerformanceServiceImpl();
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd(EEE) aaa hh:mm");			// 날짜 출력 포멧
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfRecentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Parameters
		int count = NullChecker.NullCheckParseInt(request.getParameter("count"), 4);

		// Business Logic
		ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> list = service.getRecentPerformances(count);

		JSONArray array = new JSONArray();
		for (Tuple<PerformanceSchedule, PerformanceInfomation> tuple : list) {
			JSONObject json = new JSONObject();
			json.put("perf_no", tuple.getFirst().getPerformanceNo());						// 공연번호
			json.put("schedule_no", tuple.getFirst().getScheduleNo());						// 스케줄번호
			json.put("title", tuple.getSecond().getTitle());								// 공연제목
			json.put("category", tuple.getSecond().getCategory());							// 공연카테고리
			json.put("date", dateFormat.format(tuple.getFirst().getPerformanceDate()));		// 공연일자
			json.put("location", tuple.getFirst().getLocation());							// 공연장소
			json.put("photo", NullChecker.NullCheckString(tuple.getSecond().getPhoto()));	// 공연사진

			array.add(json);
		}

		// View
		response.setCharacterEncoding(StandardCharsets.UTF_8.toString());					// Encoding
		response.setContentType("application/json");										// Content Type
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
