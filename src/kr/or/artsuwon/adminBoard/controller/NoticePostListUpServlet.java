package kr.or.artsuwon.adminBoard.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.artsuwon.adminBoard.model.service.BoardAdminService;
import kr.or.artsuwon.adminBoard.model.service.BoardAdminServiceImpl;
import kr.or.artsuwon.adminMngm.model.vo.Admin;



/**
 * Servlet implementation class NoticePostListUpServlet
 */
@WebServlet("/adminNotice/noticePostListUp.do")
public class NoticePostListUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticePostListUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));  

		HttpSession session = request.getSession();// 세션확인(어드민)
		Admin admin = (Admin)session.getAttribute("admin");
		
		if(admin == null) {
			response.sendRedirect("/views/adminCommons/error.jsp");
			return;
		}
		
		  BoardAdminService bService = new BoardAdminServiceImpl();
	     int result = bService.listUp(noticeNo);

		
		if(result ==noticeNo)
	      {
	    	  response.sendRedirect("/adminNotice/adminNoticeAllList.do");
	      }else
	      {
	    	  response.sendRedirect("/views/adminCommons/error.jsp");
	      }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
