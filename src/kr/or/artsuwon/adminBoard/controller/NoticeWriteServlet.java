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
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet("/notice/noticeWrite.do")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String NoticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		
		
		Notice notice = new Notice();
		notice.setNoticeTitle(NoticeTitle);
		notice.setNoticeContent(noticeContent);
		
		System.out.println(notice.getNoticeTitle());
		System.out.println(notice.getNoticeContent());
	
		AdminBoardService bService = new AdminBoardServiceImpl();
		int result = bService.insertPost(notice);
		
		if(result>0)
		{
			int noticeNo = bService.searchNoticeNo(notice);
			
		response.sendRedirect("/notice/noticeOneSelectContent.do?noticeNo="+noticeNo+"&currentPage=1");
		
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
