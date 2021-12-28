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
 * Servlet implementation class NoticeUpdatePostEndServlet
 */
@WebServlet("/adminNotice/NoticeUpdatePostEnd.do")
public class NoticeUpdatePostEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdatePostEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//버
			
		request.setCharacterEncoding("UTF-8");
		
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
	
		
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		
	
		BoardAdminService bService = new BoardAdminServiceImpl();
		int result = bService.insertPost(notice);
		
	
		if(result>0)
		{
			int noticeNo = bService.searchNoticeNo(notice);
			
		response.sendRedirect("/adminNotice/noticeOneSelectContent.do?noticeNo="+noticeNo+"&currentPage=1");
		
		}else
		{
			response.sendRedirect("/views/commons/error.jsp");
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
