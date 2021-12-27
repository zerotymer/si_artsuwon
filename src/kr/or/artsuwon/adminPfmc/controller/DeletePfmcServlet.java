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

@WebServlet("/adminPfmc/deletePfmc.do")
public class DeletePfmcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePfmcServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax에서 보낸 값
		String pfmcNo = request.getParameter("pfmcNo");
		
		//비지니스 로직
		PfmcService pfmcSer = new PfmcServiceImpl();
		int resultRow = pfmcSer.deletePfmc(pfmcNo);
		
		//응답
		PrintWriter out = response.getWriter();
		out.print(resultRow);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
