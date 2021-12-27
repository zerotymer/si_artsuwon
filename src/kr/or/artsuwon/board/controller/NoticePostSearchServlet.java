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
 * Servlet implementation class NoticePostSearchServlet
 */
@WebServlet("/board/NoticePostSearch.do")
public class NoticePostSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticePostSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int currentPage;
		
		if(request.getParameter("currentPage")==null)
		{

			currentPage=1;
		}else {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		

		
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		
		String keyword = request.getParameter("keyword");
		String type=request.getParameter("type");
		

		BoardService bService = new BoardServiceImpl();
		HashMap<String,Object> map = bService.NoticeSearchPost(currentPage,keyword,type);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/board/notice-board.jsp");
		
		request.setAttribute("pageDataMap", map);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("keyword", keyword);
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
