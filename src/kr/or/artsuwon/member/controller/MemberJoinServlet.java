package kr.or.artsuwon.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.member.model.vo.Member;

/**
 * Servlet implementation class MemberJoinServlet
 */
@WebServlet("/member/memberJoin.do")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String memberName = request.getParameter("memberName");
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String birthDate = request.getParameter("birthDate");
		char gender = request.getParameter("gender").charAt(0);
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		char smsYN = request.getParameter("sms").charAt(0);
		
		System.out.println(memberName);
		System.out.println(memberId);
		System.out.println(memberPwd);
		System.out.println(birthDate);
		System.out.println(gender);
		System.out.println(address);
		System.out.println(detailAddress);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(smsYN);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
