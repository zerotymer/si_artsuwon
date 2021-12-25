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

@WebServlet("/adminMngm/updateAdminInfo.do")
public class UpdateAdminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateAdminInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String adminId = request.getParameter("adminId");
		String adminName = request.getParameter("adminName");
		String adminEmail = request.getParameter("adminEmail");
		Admin admin = new Admin(adminId,adminName,adminEmail);
		
		AdminService adminSer = new AdminServiceImpl();
		int resultRow = adminSer.updateAdminInfo(admin);
		
		response.sendRedirect("/adminMngm/selectAllSubAdminList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
