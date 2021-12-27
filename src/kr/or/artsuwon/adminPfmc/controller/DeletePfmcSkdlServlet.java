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

@WebServlet("/adminPfmc/deletePfmcSkdl.do")
public class DeletePfmcSkdlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePfmcSkdlServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//삭제할 스케줄 넘버
		int scheduleNo = Integer.parseInt(request.getParameter("scheduleNo"));
		
		//비지니스 로직
		PfmcService pfmcSer = new PfmcServiceImpl();
		int resultRow = pfmcSer.deletePfmcSkdl(scheduleNo);
		
		PrintWriter out = response.getWriter();
		out.print(resultRow);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
