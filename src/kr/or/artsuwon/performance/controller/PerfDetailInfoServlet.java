package kr.or.artsuwon.performance.controller;

import kr.or.artsuwon.common.Tuple;
import kr.or.artsuwon.performance.model.service.PerformanceService;
import kr.or.artsuwon.performance.model.service.PerformanceServiceImpl;
import kr.or.artsuwon.performance.model.vo.PerformanceInfomation;
import kr.or.artsuwon.performance.model.vo.PerformanceSchedule;

import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PerfDetailInfoServlet
 */
@WebServlet("/performance/detailInfo.do")
public class PerfDetailInfoServlet extends HttpServlet {
	/// FIELDs
	private static final long serialVersionUID = 1L;
	private PerformanceService service = new PerformanceServiceImpl();
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd EEE요일 HH:mm");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfDetailInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Parameters
		int scheduleNo = Integer.parseInt(request.getParameter("scheduleNo"));

		// Business Logic
		Tuple<PerformanceSchedule, PerformanceInfomation> tuple = service.getOnePrefByScheduleNo(scheduleNo);

		// View
		RequestDispatcher view = request.getRequestDispatcher("/views/performance/detailView.jsp");
		request.setAttribute("info", tuple.getSecond());
		request.setAttribute("date", dateFormat.format(tuple.getFirst().getPerformanceDate()));
		request.setAttribute("location", tuple.getFirst().getLocation());
		request.setAttribute("price", tuple.getFirst().getPrice());
		request.setAttribute("scheduleNo", scheduleNo);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
