package kr.or.artsuwon.adminPfmc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.artsuwon.adminPfmc.model.service.PfmcService;
import kr.or.artsuwon.adminPfmc.model.service.PfmcServiceImpl;
import kr.or.artsuwon.adminPfmc.model.vo.PerformanceSkdl;

@WebServlet("/adminPfmc/selectPfmcSkdl.do")
public class SelectPfmcSkdlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SelectPfmcSkdlServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공연 스케줄 가져오기 위한 넘버 받기
		int pfmcNo = Integer.parseInt(request.getParameter("pfmcNo"));
		
		//공연넘버에 해당하는 모든 공연 스케줄 가져오기
		PfmcService pfmcSer = new PfmcServiceImpl();
		ArrayList<PerformanceSkdl> pfmcSkdlList = pfmcSer.selectPfmcSkdl(pfmcNo);
		
		//응답
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		new Gson().toJson(pfmcSkdlList,out);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
