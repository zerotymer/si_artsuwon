package kr.or.artsuwon.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.board.model.service.BoardService;
import kr.or.artsuwon.board.model.service.BoardServiceImpl;
import kr.or.artsuwon.board.model.vo.Board;

/**
 * Servlet implementation class NewsSelectContentServlet
 */
@WebServlet("/board/NewsSelectContent.do")
public class NewsSelectContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsSelectContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		BoardService bService = new BoardServiceImpl();
		Board board = bService.NewsSelectOnePost(boardNo);
		

		RequestDispatcher view = request.getRequestDispatcher("/views/board/news-board-content.jsp");
		
		request.setAttribute("board", board);
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
