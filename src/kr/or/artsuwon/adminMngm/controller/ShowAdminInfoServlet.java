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

@WebServlet("/adminMngm/showAdminInfo.do")
public class ShowAdminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowAdminInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자 세션체크
		Admin adminSession = (Admin)request.getSession().getAttribute("admin");
				
		//세션이 없거나 or 세션이있으나 슈퍼관리자가 아닌경우 접근 불가
		//일반관리자가 본인 프로필 수정시 세션과 본인 불일치시 접근 불가
		if(adminSession == null || (adminSession != null && adminSession.getSuperAdminYN() == 'N' 
			&& adminSession.getAdminNo() != Integer.parseInt(request.getParameter("adminNo")))) {
			response.sendRedirect("/views/adminCommon/error.jsp");
			return;
		}
		
		//수정할 운영자 넘버값 가져오기 (쿼리스트링)
		int adminNo = Integer.parseInt(request.getParameter("adminNo"));
		
		//비지니스 로직
		AdminService adminSer = new AdminServiceImpl();
		Admin admin = adminSer.showAdminInfo(adminNo);
		
		//페이지 이동
		RequestDispatcher RD = request.getRequestDispatcher("/views/adminMngm/adminInfo.jsp");
		request.setAttribute("admin", admin);
		RD.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
