package kr.or.artsuwon.adminPfmc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminPfmc.model.service.PfmcService;
import kr.or.artsuwon.adminPfmc.model.service.PfmcServiceImpl;
import kr.or.artsuwon.adminPfmc.model.vo.PerformanceSkdl;

@WebServlet("/adminPfmc/insertPfmcSkdl.do")
public class InsertPfmcSkdlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertPfmcSkdlServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax 파라미터 받기
		request.setCharacterEncoding("utf-8");
		int pfmcNo = Integer.parseInt(request.getParameter("pfmcNo"));
		String pfmcDate = request.getParameter("pfmcDate");
		String pfmcTime = request.getParameter("pfmcTime");
		String location = request.getParameter("location");
		String price = request.getParameter("price");
		String restrictionName = request.getParameter("restriction");
		int restriction = 0; 
			switch (restrictionName) {
			case "1단계": {
				restriction = 1; break;
				}
			case "2단계": {
				restriction = 2; break;
				}
			case "3단계": {
				restriction = 3; break;
				}
			}
		PerformanceSkdl pfmcSkdl = new PerformanceSkdl(pfmcNo,pfmcDate,pfmcTime,location,price,restriction);
		
		//비지니스 로직 처리
		PfmcService pfmcSer = new PfmcServiceImpl();
		int scheduleNo = pfmcSer.insertPfmcSkdl(pfmcSkdl);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(scheduleNo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
