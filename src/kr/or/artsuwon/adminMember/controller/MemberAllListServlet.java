package kr.or.artsuwon.adminMember.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.artsuwon.adminMember.service.AdminMemberService;
import kr.or.artsuwon.adminMember.service.AdminMemberServiceImpl;
import kr.or.artsuwon.adminMngm.model.vo.Admin;
import kr.or.artsuwon.member.model.vo.Member;

/**
 * Servlet implementation class MemberAllListServlet
 */
@WebServlet("/admin/adminCheck.do")
public class MemberAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAllListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");*/

		HttpSession session = request.getSession();
		
		int adminNo = ((Admin)session.getAttribute("admin")).getAdminNo();
		
		
		
		if(adminNo<1) //관리자가 아닌 경우
		{
			response.sendRedirect("/views/commons/error.jsp");
			return;
			
		}
		
		adminNo = AuthorityCheck(request, response);
		
		AdminMemberService adService = new AdminMemberServiceImpl();
		
		ArrayList<Member> list = adService.selectAllMemberList(adminNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/adminMemberSelect.jsp");
		
		request.setAttribute("list", list);
		request.setAttribute("adminNo", adminNo);
		
		view.forward(request, response);
		
		
		
	}

	private int AuthorityCheck(HttpServletRequest request, HttpServletResponse response) {
		

		HttpSession session = request.getSession();
		Object obj = session.getAttribute("admin"); 
		
		if(obj ==null) 
		{
			return 0;
		}
		
		
		Admin a = (Admin)obj; 
		
		if(a.getAdminNo()>0) 
		{
			return 0;
		}else  //관리자라면
		{
			return a.getAdminNo();
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
