package kr.or.artsuwon.member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		//date 타입
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	      
	    String memberName = request.getParameter("memberName");
	    String memberId = request.getParameter("memberId");
	    String memberPwd = request.getParameter("memberPwd");
	    String birthDate1 = request.getParameter("birthDate1");
	    String birthDate2 = request.getParameter("birthDate2");
	    String birthDate3 = request.getParameter("birthDate3");
	    
	    Date date = null;
	    try {
	       date = dateFormat.parse(String.format("%s-%s-%s", birthDate1, birthDate2, birthDate3));
	    } catch (ParseException e) {
	       e.printStackTrace();
	    }
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    
	    char gender = request.getParameter("gender").charAt(0);
	    String address = request.getParameter("address");
	    String detailAddress = request.getParameter("detailAddress");
	    String phone1 = request.getParameter("phone1");
	    String phone2 = request.getParameter("phone2");
	    String phone3 = request.getParameter("phone3");
	    String email1 = request.getParameter("email1");
	    String email2 = request.getParameter("email2");
	    char smsYN = request.getParameter("smsYN").charAt(0);
	    String phone = String.format("%s-%s-%s", phone1, phone2, phone3);
	      
	      
	    Member m = new Member(memberName, memberId, memberPwd, sqlDate, gender, address, detailAddress, phone, email1+"@"+email2, smsYN);
		
		MemberService mService = new MemberServiceImpl();
		int result = mService.insertOneMember(m);
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/member/memberJoin.jsp");
		
		if(result>0)
		{
			request.setAttribute("result",true);
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
