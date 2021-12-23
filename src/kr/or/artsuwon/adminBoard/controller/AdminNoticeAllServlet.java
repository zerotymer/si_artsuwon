package kr.or.artsuwon.adminBoard.controller;



import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.artsuwon.adminBoard.service.AdminBoardService;
import kr.or.artsuwon.adminBoard.service.AdminBoardServiceImpl;
import kr.or.artsuwon.board.model.service.BoardServiceImpl;


/**
 * Servlet implementation class AdminNoticeAllServlet
 */
@WebServlet("/notice/adminNoticeAllList.do")
public class AdminNoticeAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeAllServlet() {
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
			currentPage =1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		AdminBoardService bService = new AdminBoardServiceImpl();
		
		HashMap<String,Object> pageDataMap = bService.selectAllPostList(currentPage);
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("read", "n");
		
		
		request.setAttribute("pageDataMap", pageDataMap);
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/board/noticeAllList.jsp");
		
		request.setAttribute("pageDataMap", pageDataMap);
		request.setAttribute("currentPage",currentPage);
		
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
