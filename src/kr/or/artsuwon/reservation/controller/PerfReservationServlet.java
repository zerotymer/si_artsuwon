package kr.or.artsuwon.reservation.controller;

import kr.or.artsuwon.member.model.vo.Member;
import kr.or.artsuwon.reservation.model.service.ReservationService;
import kr.or.artsuwon.reservation.model.service.ReservationServiceImpl;
import kr.or.artsuwon.reservation.model.vo.Reservation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PerfReservationServlet
 */
@WebServlet("/reservation/book.do")
public class PerfReservationServlet extends HttpServlet {
	/// FIELDs
	private static final long serialVersionUID = 1L;
	private ReservationService service = new ReservationServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Parameters
		int scheduleNo = Integer.parseInt(request.getParameter("scheduleNo"));
		int price = Integer.parseInt(request.getParameter("price"));
		String seatCode = request.getParameter("seatCode");
		String invoiceNo = request.getParameter("invoiceNo");

		// Session
		Member member = (Member) request.getSession().getAttribute("member");

		Reservation reservation = new Reservation();
		reservation.setPerformanceNo(scheduleNo);
		reservation.setInvoiceNo(invoiceNo);
		reservation.setReservationId(member.getMemberId());
		reservation.setReservationPrice(price);
		reservation.setSeatCode(seatCode);
		// Business Logic
		boolean result = service.insertReservation(reservation);

		// View
		RequestDispatcher view = request.getRequestDispatcher("/views/reservation/bookResult.jsp");
		request.setAttribute("result", result);
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
