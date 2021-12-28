package kr.or.artsuwon.member.controller;

import java.io.IOException;
import java.util.ArrayList;

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
import kr.or.artsuwon.member.model.vo.Reservation;

/**
 * Servlet implementation class MemberMyPageServlet
 */
@WebServlet("/member/memberMyPage.do")
public class MemberMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//로그인 정보
	    String memberId = ((Member)(request.getSession()).getAttribute("member")).getMemberId();
	    String memberPwd = ((Member)(request.getSession()).getAttribute("member")).getMemberPwd();
	
		MemberService mService = new MemberServiceImpl();
		Member m = mService.selectOneMember(memberId, memberPwd);
	
		
		RequestDispatcher view;
		
		if(session.getAttribute("member") == null)
		{
			view = request.getRequestDispatcher("/views/common/memberError.jsp");
			view.forward(request, response);
			return;
			
		}
		
		
		
		
		//공연예매 정보
		ArrayList<Reservation> list = mService.selectMemberReservation(memberId);
		
		view = request.getRequestDispatcher("/views/member/myPage.jsp");
	
		request.setAttribute("member", m);
		request.setAttribute("list", list);
		
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
