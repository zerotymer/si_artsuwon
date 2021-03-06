package kr.or.artsuwon.adminBoard.controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminBoard.model.service.BoardAdminService;
import kr.or.artsuwon.adminBoard.model.service.BoardAdminServiceImpl;
import kr.or.artsuwon.adminBoard.model.vo.Notice;



/**
 * Servlet implementation class NoticeUpdatePostReadServlet
 */
@WebServlet("/adminNotice/noticePostReadUpdate.do")
public class NoticeUpdatePostReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdatePostReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));  
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		
		BoardAdminService bService = new BoardAdminServiceImpl();
		Notice notice = bService.selectOneContent(noticeNo);
	

		
		RequestDispatcher view = request.getRequestDispatcher("/views/adminBoard/NoticeUpdateForm.jsp");
		request.setAttribute("notice", notice);
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
