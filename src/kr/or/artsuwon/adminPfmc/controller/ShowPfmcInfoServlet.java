package kr.or.artsuwon.adminPfmc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminMngm.model.vo.Admin;
import kr.or.artsuwon.adminPfmc.model.service.PfmcService;
import kr.or.artsuwon.adminPfmc.model.service.PfmcServiceImpl;
import kr.or.artsuwon.adminPfmc.model.vo.Performance;

@WebServlet("/adminPfmc/showPfmcInfo.do")
public class ShowPfmcInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowPfmcInfoServlet() {
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
		
		//수정할 공연 넘버값 가져오기 (쿼리스트링)
		int pfmcNo = Integer.parseInt(request.getParameter("pfmcNo"));
		
		//비지니스 로직
		PfmcService pfmcSer = new PfmcServiceImpl();
		Performance pfmc = pfmcSer.showPfmcInfo(pfmcNo);
		
		//페이지 이동
		RequestDispatcher RD = request.getRequestDispatcher("/views/adminPfmc/pfmcInfo.jsp");
		request.setAttribute("pfmc", pfmc);
		request.setAttribute("pfmcNo", pfmcNo);
		RD.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
