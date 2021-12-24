package kr.or.artsuwon.adminMngm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminMngm.model.service.AdminService;
import kr.or.artsuwon.adminMngm.model.service.AdminServiceImpl;


@WebServlet("/adminMngm/adminIdCheck.do")
public class AdminIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminIdCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax가 전송한 값 받기
		String adminId = request.getParameter("adminId");
		
		//비지니스 로직
		AdminService adminSer = new AdminServiceImpl();
		boolean result = adminSer.idCheck(adminId);
		
		//응답
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
