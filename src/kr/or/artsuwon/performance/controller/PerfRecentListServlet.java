package kr.or.artsuwon.performance.controller;

import kr.or.artsuwon.common.Tuple;
import kr.or.artsuwon.performance.model.service.PerformanceService;
import kr.or.artsuwon.performance.model.service.PerformanceServiceImpl;
import kr.or.artsuwon.performance.model.vo.PerformanceInfomation;
import kr.or.artsuwon.performance.model.vo.PerformanceSchedule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
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
		int count = request.getParameter("count") != null ? Integer.parseInt(request.getParameter("count")) : 4;

		// Business Logic
		ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> list = service.getRecentPerformances(count);

		JSONArray array = new JSONArray();
		for (Tuple<PerformanceSchedule, PerformanceInfomation> tuple : list) {
			JSONObject map = new JSONObject();
			map.put("no", tuple.getFirst().getPerformanceNo());			// 공연번호
			map.put("title", tuple.getSecond().getTitle());				// 공연제목
			map.put("date", tuple.getFirst().getPerformnaceDate());		// 공연일자
			map.put("location", tuple.getFirst().getLocation());		// 공연장소
			map.put("photo", tuple.getSecond().getPhoto());				// 공연사진
			array.add(map);
		}

		// View
		response.setCharacterEncoding("UTF-8");							// Encoding
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
