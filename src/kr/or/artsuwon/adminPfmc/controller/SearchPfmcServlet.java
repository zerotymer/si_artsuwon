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

@WebServlet("/adminPfmc/searchPfmc.do")
public class SearchPfmcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchPfmcServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자 세션체크
		Admin adminSession = (Admin)request.getSession().getAttribute("admin");
				
		// 세션이 없거나 or 세션이있으나 슈퍼관리자가 아닌경우 접근 불가
		if(adminSession == null || (adminSession != null && adminSession.getSuperAdminYN() == 'N')) {
			response.sendRedirect("/views/commons/error.jsp");
			return;
		}
		
		//검색 조건들 받기
		request.setCharacterEncoding("utf-8");
		String srchDate = request.getParameter("srchDate");
		String srchCategory = request.getParameter("srchCategory");
		String srchPfmcName = request.getParameter("srchPfmcName");
		String queryString = request.getQueryString();
		
		//비지니스 로직
		int currentPage;
		if(request.getParameter("currentPage")==null) currentPage = 1;
		else currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		PfmcService pfmcSer = new PfmcServiceImpl();
		HashMap<String, Object> pfmcListMap = pfmcSer.searchPfmc(currentPage,srchDate,srchCategory,srchPfmcName, queryString);
		
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
