package kr.or.artsuwon.adminBoard.controller;

<<<<<<< HEAD


import java.io.IOException;
import java.util.HashMap;
=======
import kr.or.artsuwon.adminBoard.model.service.BoardAdminService;
import kr.or.artsuwon.adminBoard.model.service.BoardAdminServiceImpl;
>>>>>>> 53fdcb91b1146cc383c8528d72825908e003e2a7

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD

import kr.or.artsuwon.adminBoard.service.AdminBoardService;
import kr.or.artsuwon.adminBoard.service.AdminBoardServiceImpl;
import kr.or.artsuwon.board.model.service.BoardServiceImpl;

=======
import java.io.IOException;
import java.util.HashMap;
>>>>>>> 53fdcb91b1146cc383c8528d72825908e003e2a7

/**
 * Servlet implementation class AdminNoticeAllServlet
 */
@WebServlet("/notice/adminNoticeAllList.do")
public class AdminNoticeAllServlet extends HttpServlet {
<<<<<<< HEAD
	private static final long serialVersionUID = 1L;
       
=======
    private static final long serialVersionUID = 1L;

>>>>>>> 53fdcb91b1146cc383c8528d72825908e003e2a7
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

<<<<<<< HEAD
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
=======
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int currentPage;

        if (request.getParameter("currentPage") == null) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }

        BoardAdminService bService = new BoardAdminServiceImpl();

        HashMap<String, Object> pageDataMap = bService.selectAllPostList(currentPage);


        HttpSession session = request.getSession();

        session.setAttribute("read", "n");


        request.setAttribute("pageDataMap", pageDataMap);


        RequestDispatcher view = request.getRequestDispatcher("/views/board/noticeAllList.jsp");

        request.setAttribute("pageDataMap", pageDataMap);
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
>>>>>>> 53fdcb91b1146cc383c8528d72825908e003e2a7

}
