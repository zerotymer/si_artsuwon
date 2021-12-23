package kr.or.artsuwon.adminBoard.controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminBoard.service.AdminBoardService;
import kr.or.artsuwon.adminBoard.service.AdminBoardServiceImpl;
import kr.or.artsuwon.adminBoard.vo.Notice;
import kr.or.artsuwon.board.model.service.BoardServiceImpl;


/**
 * Servlet implementation class NoticeOneSelectContentServlet
 */
@WebServlet("/notice/noticeOneSelectContent.do")
public class NoticeOneSelectContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeOneSelectContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		
		int currentPage = 0;
		
		 
		//numberformatexception (null) 오류처리 
		if(request.getParameter("currentPage")!=null 
		           && request.getParameter("currentPage")!="")
		{
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
		AdminBoardService bService = new AdminBoardServiceImpl();
		Notice notice = bService.selectOneContent(noticeNo);
	


		
			RequestDispatcher view = request.getRequestDispatcher("/views/board/NoticeOneSelect.jsp");
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
