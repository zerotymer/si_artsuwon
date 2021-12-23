package kr.or.artsuwon.adminBoard.controller;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminBoard.service.AdminBoardService;
import kr.or.artsuwon.adminBoard.service.AdminBoardServiceImpl;
import kr.or.artsuwon.adminBoard.vo.Notice;


/**
 * Servlet implementation class NoticePostUpdatServlet
 */
@WebServlet(name = "NoticePostUpdateServlet", urlPatterns = { "/notice/noticePostUpdate.do" })
public class NoticePostUpdatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticePostUpdatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param noticeNo 
	 * @param noticeNo 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String noticeContent = request.getParameter("noticeContent");
		String noticeTitle = request.getParameter("noticeTitle");
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));  
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		
		
		Notice notice = new Notice();
		notice.setNoticeContent(noticeContent);
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeNo(noticeNo);
		
		
		
		AdminBoardService bService = new AdminBoardServiceImpl();
		int result = bService.updatePost(notice);
		
		
		if(result>0)
		{
			response.sendRedirect("/notice/noticeOneSelectContent.do?noticeNo="+noticeNo+"&currentPage="+currentPage);
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

