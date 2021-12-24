package kr.or.artsuwon.adminMngm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.artsuwon.adminMngm.model.service.AdminService;
import kr.or.artsuwon.adminMngm.model.service.AdminServiceImpl;
import kr.or.artsuwon.adminMngm.model.vo.Admin;

@WebServlet("/adminMngm/selectAllSubAdminList.do")
public class SelectAllSubAdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectAllSubAdminListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자 세션체크
		Admin adminSession = (Admin)request.getSession().getAttribute("admin");
		
		// 세션이 없거나 or 세션이있으나 슈퍼관리자가 아닌경우 접근 불가
		if(adminSession == null || (adminSession != null && adminSession.getSuperAdminYN() == 'N')) {
			response.sendRedirect("/views/adminCommon/error.jsp");
			return;
		}
		
		//비지니스 로직 (현재 페이지 번호에 따른 운영진 목록과 네비바 정보 가져오기)
		int currentPage;
		if(request.getParameter("currentPage")==null) currentPage = 1;
		else currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		AdminService adminSer = new AdminServiceImpl();
		HashMap<String, Object> adminListMap = adminSer.selectAllSubAdmin(currentPage);
		
		//페이지 이동
		RequestDispatcher RD;
		if(!adminListMap.isEmpty()) {
			RD = request.getRequestDispatcher("/views/adminMngm/subAdminManagement.jsp");
			request.setAttribute("adminListMap", adminListMap);
			request.setAttribute("currentPage", currentPage);
		}else {
			RD = request.getRequestDispatcher("/views/adminCommon/error.jsp");
		}
		RD.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

