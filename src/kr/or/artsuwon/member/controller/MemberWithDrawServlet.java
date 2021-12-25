package kr.or.artsuwon.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.artsuwon.member.model.service.MemberService;
import kr.or.artsuwon.member.model.service.MemberServiceImpl;
import kr.or.artsuwon.member.model.vo.Member;

/**
 * Servlet implementation class MemberWithDrawServlet
 */
@WebServlet("/member/memberWithDraw.do")
public class MemberWithDrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberWithDrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		int memberNo = m.getMemberNo();
		
		MemberService mService = new MemberServiceImpl();
		int result = mService.deleteOneMember(memberNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/member/memberWithDraw.jsp");
		
		if(result>0)
		{
			request.setAttribute("result", true);
			session.invalidate();
			
		}else {
			request.setAttribute("result", false);
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
