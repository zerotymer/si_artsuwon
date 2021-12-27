package kr.or.artsuwon.adminMngm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminMngm.model.service.AdminService;
import kr.or.artsuwon.adminMngm.model.service.AdminServiceImpl;

@WebServlet("/adminMngm/deleteAdmin.do")
public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteAdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//삭제할 adminNo 가져오기
		String adminNo = request.getParameter("adminNo");
		
		//비지니스 로직
		AdminService adminSer = new AdminServiceImpl();
		int resultRow = adminSer.deleteAdmin(adminNo);
		
		//응답
		PrintWriter out = response.getWriter();
		out.print(resultRow);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
