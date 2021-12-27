package kr.or.artsuwon.reservation.controller;

import kr.or.artsuwon.reservation.model.service.ReservationService;
import kr.or.artsuwon.reservation.model.service.ReservationServiceImpl;
import kr.or.artsuwon.reservation.model.vo.Reservation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestSeatInfoServlet
 */
@WebServlet("/seat/requestInfo.do")
public class RequestSeatInfoServlet extends HttpServlet {
	/// FIELDs
	private static final long serialVersionUID = 1L;
	private ReservationService service = new ReservationServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestSeatInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
