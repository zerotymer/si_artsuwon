package kr.or.artsuwon.adminMngm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminMngm.model.service.AdminService;
import kr.or.artsuwon.adminMngm.model.service.AdminServiceImpl;
import kr.or.artsuwon.adminMngm.model.vo.Admin;

@WebServlet("/adminMngm/updateAdminPwd.do")
public class UpdateAdminPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateAdminPwdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 비번과 변경할 비번 받기
		String currentPwd = request.getParameter("currentPwd");
		String newPwd = request.getParameter("newPwd");
		
		//비밀번호 변경하려는 관리자 번호
		int adminNo = ((Admin)request.getSession().getAttribute("admin")).getAdminNo();
		
		//비지니스 로직
		AdminService adminSer = new AdminServiceImpl();
		int resultRow = adminSer.updateAdminPwd(adminNo, currentPwd, newPwd);
		
		//일단 빈 메인으로 이동
		response.sendRedirect("/views/adminMngm/adminMain.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
