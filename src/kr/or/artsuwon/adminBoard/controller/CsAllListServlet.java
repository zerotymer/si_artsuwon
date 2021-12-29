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
 * Servlet implementation class CsAllListServlet
 */
@WebServlet("/adminNotice/CsAllList.do")
public class CsAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsAllListServlet() {
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
			currentPage = 1;
		}else {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));	
			
		}	
		
		
	    BoardAdminService bService = new BoardAdminServiceImpl();
	    HashMap<String,Object> CsAllList = bService.CsAllList(currentPage);
	    
		RequestDispatcher view = request.getRequestDispatcher("/views/adminBoard/CsAllList.jsp");

		request.setAttribute("CsAllList", CsAllList);
		
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
