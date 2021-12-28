package kr.or.artsuwon.reservation.controller;

import com.google.gson.Gson;
import kr.or.artsuwon.common.NullChecker;
import kr.or.artsuwon.reservation.model.service.ReservationService;
import kr.or.artsuwon.reservation.model.service.ReservationServiceImpl;
import kr.or.artsuwon.reservation.model.vo.Reservation;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestAllReserveSeatServlet
 */
@WebServlet("/seat/requestReservedSeat.json")
public class RequestAllReserveSeatServlet extends HttpServlet {
	/// FIELDs
	private static final long serialVersionUID = 1L;
	private ReservationService service = new ReservationServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestAllReserveSeatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Parameters
		int scheduleNo = NullChecker.NullCheckParseInt(request.getParameter("scheduleNo"), 73);

		// Business Logic
		ArrayList<Reservation> list = service.getAllReservationByPerfSchedule(scheduleNo);

		// Encoding
		JSONObject json = new JSONObject();
		for (Reservation r : list) {
			json.put(r.getSeatCode(), r.getSeatCode());
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
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
