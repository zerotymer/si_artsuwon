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
 * Servlet implementation class MemberPwdChangeServlet
 */
@WebServlet("/member/memberPwdChange.do")
public class MemberPwdChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPwdChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
request.setCharacterEncoding("UTF-8");
		
		String pwd = request.getParameter("pwd");
		String newPwd = request.getParameter("new_pwd");
		
		//session에서 해당 유저를 구분할 수 있는 정보를 추출
		String memberId = ((Member)request.getSession().getAttribute("member")).getMemberId();
		
		//패스워드 변경을 위한 비즈니스 로직
		MemberService mService = new MemberServiceImpl();
		int result = mService.updatePwdMember(memberId, pwd, newPwd);
		
		//변경 성공 : 정상적으로 기존 패스워드와 변경할 때 패스워드를 입력했다면 / result값은 1
		//변경 실패 : 기존 패스워드가 잘 못 되었을 때 / result값은 0
		
		RequestDispatcher view = request.getRequestDispatcher("/views/member/memberPwdChResult.jsp");
		
		if(result>0)
		{
			request.setAttribute("pwdResult", true);
		}else {
			request.setAttribute("pwdResult", false);
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
