package kr.or.artsuwon.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.member.model.service.MemberService;
import kr.or.artsuwon.member.model.service.MemberServiceImpl;
import kr.or.artsuwon.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/member/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String address = request.getParameter("address");
	    String detailAddress = request.getParameter("detailAddress");
	    String phone1 = request.getParameter("phone1");
	    String phone2 = request.getParameter("phone2");
	    String phone3 = request.getParameter("phone3");
	    String email1 = request.getParameter("email1");
	    String email2 = request.getParameter("email2");
	    char smsYN = request.getParameter("smsYN").charAt(0);
	    
		
	    String memberId = ((Member)(request.getSession()).getAttribute("member")).getMemberId();
		
	    Member m = new Member(memberId, address, detailAddress, phone1+phone2+phone3, email1+email2, smsYN, smsYN);
	    
	    MemberService mService = new MemberServiceImpl();
	    int result = mService.updateOneMember(m);
	    
	    RequestDispatcher view = request.getRequestDispatcher("/views/member/memberUpdateResult.jsp");
		
		if(result>0)
		{
			request.setAttribute("updateResult", true);
		}else {
			request.setAttribute("updateResult", false);
		}
		
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
