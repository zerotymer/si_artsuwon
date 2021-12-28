package kr.or.artsuwon.reservation.controller;

import kr.or.artsuwon.common.NullChecker;
import kr.or.artsuwon.reservation.model.service.ReservationService;
import kr.or.artsuwon.reservation.model.service.ReservationServiceImpl;
import kr.or.artsuwon.reservation.model.vo.SeatInfomation;
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
		/// Paramerters
		int restriction = NullChecker.NullCheckParseInt(request.getParameter("restriction"), 5);	// 제약조건: 기본 5(모두 가능)

		// Business Logic
		ArrayList<SeatInfomation> list = service.getAllSeatsByRestriction(restriction);

		// return Json
		JSONObject json = new JSONObject();
		for (SeatInfomation seat : list) {
			JSONObject obj = new JSONObject();
			obj.put("code", seat.getCode().trim());
			obj.put("location", String.valueOf(seat.getLocation()));
			obj.put("grade", String.valueOf(seat.getGrade()));
			obj.put("restriction", String.valueOf(seat.getRestriction()));
			obj.put("special", seat.getSpecialNeed() == 'Y');

			json.put(seat.getCode().trim(), obj);
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
