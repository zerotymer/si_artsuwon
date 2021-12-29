package kr.or.artsuwon.performance.controller;

import kr.or.artsuwon.common.DateConverter;
import kr.or.artsuwon.common.NullChecker;
import kr.or.artsuwon.common.Tuple;
import kr.or.artsuwon.performance.model.service.PerformanceService;
import kr.or.artsuwon.performance.model.service.PerformanceServiceImpl;
import kr.or.artsuwon.performance.model.vo.PerformanceInfomation;
import kr.or.artsuwon.performance.model.vo.PerformanceSchedule;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PerfDetailInfoAjaxServelt
 */
@WebServlet("/performance/detailInfo.json")
public class PerfDetailInfoAjaxServelt extends HttpServlet {
	/// FIELDs
	private static final long serialVersionUID = 1L;
	private PerformanceService service = new PerformanceServiceImpl();
	private final String dateFormat = "yyyy.MM.dd EEE요일 HH:mm";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfDetailInfoAjaxServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Parameters
		int scheduleNo = NullChecker.NullCheckParseInt(request.getParameter("scheduleNo"));

		// Business Logic
		Tuple<PerformanceSchedule, PerformanceInfomation> tuple = service.getOnePrefByScheduleNo(scheduleNo);

		// Json Response
		JSONObject json = new JSONObject();
		json.put("title", tuple.getSecond().getTitle());
		json.put("location", tuple.getFirst().getLocation());
		json.put("price", tuple.getFirst().getPrice());
		json.put("date", DateConverter.convertSQLDateToString(tuple.getFirst().getPerformanceDate(), dateFormat));
		json.put("restriction", tuple.getFirst().getRestriction());

		response.setContentType("application/json; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
