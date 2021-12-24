package kr.or.artsuwon.adminMngm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminMngm.model.service.AdminService;
import kr.or.artsuwon.adminMngm.model.service.AdminServiceImpl;
import kr.or.artsuwon.adminMngm.model.vo.Admin;

@WebServlet("/adminMngm/insertAdmin.do")
public class InsertAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertAdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//운영진 추가 등록 파라미터 받기
		request.setCharacterEncoding("utf-8");
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		String adminName = request.getParameter("adminName");
		String adminEmail = request.getParameter("adminEmail");
		Admin admin = new Admin(adminId, adminPwd, adminName, adminEmail);
		
		//비지니스 로직
		AdminService adminSer = new AdminServiceImpl();
		adminSer.insertOneAdmin(admin);
		
		//다시 운영진 목록 페이지로 이동 
		response.sendRedirect("/adminMngm/selectAllSubAdminList.do");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
