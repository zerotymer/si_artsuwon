package kr.or.artsuwon.reservation.controller;

import com.google.gson.Gson;
import kr.or.artsuwon.reservation.model.service.ReservationService;
import kr.or.artsuwon.reservation.model.service.ReservationServiceImpl;
import kr.or.artsuwon.reservation.model.vo.Reservation;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestAllReservationServlet
 */
@WebServlet("/reservation/requestAll.do")
public class RequestAllReservationServlet extends HttpServlet {
	/// FIELDs
	private static final long serialVersionUID = 1L;
	private ReservationService service = new ReservationServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestAllReservationServlet() {
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
		ArrayList<Reservation> list = service.getAllReservationByPerfSchedule(scheduleNo);

		// Encoding
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		new Gson().toJson(list, out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
