package kr.or.artsuwon.adminMember.controller;

import java.io.IOException;

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

/**
 * Servlet implementation class MemberEndYNChangeServlet
 */
@WebServlet("/admin/memberEndYNChange.do")
public class MemberEndYNChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEndYNChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// 이 요청을 수행한 사람의 권한 확인(최고 권한 관리자인지 아닌지)
		char roll = authorityRootCheck(request, response);
		
		if(roll=='0')//권한이 없는 사람이라면 더이상 진행하지 말아라
		{
			response.sendRedirect("/views/adminCommon/error.jsp");
			return;
		}
		
		
		
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		char memberStatus = request.getParameter("memberStatus").charAt(0);
		
		if(memberStatus=='2') memberStatus='0';
		else		   memberStatus='2';
		
		
		AdminMemberService adService = new AdminMemberServiceImpl();
		int result = adService.updateMemberEndYN(memberNo,memberStatus);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/updateMemberEndYN.jsp");
		
		if(result>0) request.setAttribute("result", true);
		else		request.setAttribute("result", false);
		
		view.forward(request, response);
	}

	
	
	
	private char authorityRootCheck(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("admin"); 
		
		if(obj ==null) 
		{
			return 0; //로그인을 하지 않은 사용자라면
		}
		
		
		Admin a = (Admin)obj; 
		
		if(a.getSuperAdminYN()!='Y') 
		{
			return 0;
		}else  //관리자라면
		{
			return a.getSuperAdminYN();
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
