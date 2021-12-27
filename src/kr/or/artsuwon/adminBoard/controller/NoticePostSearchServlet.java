package kr.or.artsuwon.adminBoard.controller;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminBoard.model.service.BoardAdminService;
import kr.or.artsuwon.adminBoard.model.service.BoardAdminServiceImpl;



/**
 * Servlet implementation class NoticePostSearchServlet
 */
@WebServlet("/notice/noticePostSearch.do")
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
		
		if(request.getParameter("currentPage") == null)
		{	// 즉, index.jsp 에서 게시판으로 이동하는 경우에는 가장 첫페이지인 1page로 셋팅
			currentPage = 1;
		}else {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));	
			
		}	
	
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");
	/*	System.out.println(keyword);
		System.out.println(type);
		*/
		BoardAdminService bService = new BoardAdminServiceImpl();
		HashMap<String,Object> map = bService.selectSearchPost(currentPage,keyword,type);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/adminBoard/noticeAllList.jsp");
		
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
