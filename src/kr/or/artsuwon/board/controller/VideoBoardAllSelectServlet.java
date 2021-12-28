package kr.or.artsuwon.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.board.model.service.BoardService;
import kr.or.artsuwon.board.model.service.BoardServiceImpl;

/**
 * Servlet implementation class VideoBoardAllSelectServlet
 */
@WebServlet("/board/VideoAllSelect.do")
public class VideoBoardAllSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoBoardAllSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;

		if (request.getParameter("currentPage") == null) {
			
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		
		BoardService bService = new BoardServiceImpl();
		HashMap<String, Object> pageDataMap = bService.VideoSelect(currentPage);

		RequestDispatcher view = request.getRequestDispatcher("/views/board/video-board.jsp");

		request.setAttribute("pageDataMap", pageDataMap);
		request.setAttribute("currentPage", currentPage);
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
