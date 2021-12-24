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


/**
 * Servlet implementation class NoticePostDeleteServlet
 */
@WebServlet("/board/noticePostDelete.do")
public class NoticePostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticePostDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));  
		System.out.println(request.getParameter("noticeNo"));
		
		BoardAdminService bService = new BoardAdminServiceImpl();
		int result = bService.deletePost(noticeNo);
		
		//TODO : SESSION 추가 
		
		RequestDispatcher view = request.getRequestDispatcher("/views/board/NoticedeletePost.jsp");
		
	/*	if(result>0)
		{
			request.setAttribute("result", true);
		}else
		{
			request.setAttribute("result", false);
		}
		*/
		request.setAttribute("result", result> 0);

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
