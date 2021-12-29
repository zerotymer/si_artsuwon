package kr.or.artsuwon.adminPfmc.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminMngm.model.vo.Admin;
import kr.or.artsuwon.adminPfmc.model.service.PfmcService;
import kr.or.artsuwon.adminPfmc.model.service.PfmcServiceImpl;

@WebServlet("/adminPfmc/selectAllPfmcList.do")
public class SelectAllPfmcListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectAllPfmcListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자 세션체크
		Admin adminSession = (Admin)request.getSession().getAttribute("admin");
				
		// 세션이 없는 경우 접근 불가
		if(adminSession == null) {
			response.sendRedirect("/views/adminCommon/error.jsp");
			return;
		}

		//비지니스 로직 (현재 페이지 번호에 따른 공연 목록과 네비바 정보 가져오기)
		int currentPage;
		if(request.getParameter("currentPage")==null) currentPage = 1;
		else currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		PfmcService pfmcSer = new PfmcServiceImpl();
		HashMap<String, Object> pfmcListMap = pfmcSer.selectAllPfmc(currentPage);
		
		// 페이지 이동
		RequestDispatcher RD;
		if (!pfmcListMap.isEmpty()) {
			RD = request.getRequestDispatcher("/views/adminPfmc/pfmcSelectAllList.jsp");
			request.setAttribute("pfmcListMap", pfmcListMap);
			request.setAttribute("currentPage", currentPage);
			
		} else {
			RD = request.getRequestDispatcher("/views/adminCommon/error.jsp");
		}
		
		RD.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
