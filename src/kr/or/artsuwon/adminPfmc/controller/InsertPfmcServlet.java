package kr.or.artsuwon.adminPfmc.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.artsuwon.adminPfmc.model.service.PfmcService;
import kr.or.artsuwon.adminPfmc.model.service.PfmcServiceImpl;
import kr.or.artsuwon.adminPfmc.model.vo.Performance;

@WebServlet("/adminPfmc/insertPfmc.do")
public class InsertPfmcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertPfmcServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공연 등록 파라미터 받기 (10개)
		request.setCharacterEncoding("utf-8");
		
		//파일 등록
		String uploadFilePath = request.getServletContext().getRealPath("/upload/show");
		int fileSizeLimit = 1024*1024*50;
		String encType="utf-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, fileSizeLimit, encType, new DefaultFileRenamePolicy());
		
		String category = multi.getParameter("category");
		String title = multi.getParameter("title");
		String conductor = multi.getParameter("conductor");
		String collaborator = multi.getParameter("collaborator");
		String programs = multi.getParameter("programs");
		String introduction = multi.getParameter("introduction");
		String programNote = multi.getParameter("programNote");
		String relatedPackage = multi.getParameter("relatedPackage");
		String memo = multi.getParameter("memo");
		String photo = multi.getFilesystemName("file");
		
		//동적 테이블 파라미터 (5개)
		String pfmcDate = multi.getParameter("pfmcDate");
		String pfmctime = multi.getParameter("pfmctime");
		String location = multi.getParameter("location");
		String price = multi.getParameter("price");
		String restriction = multi.getParameter("restriction");
		
		//총 15개
		Performance pfmc = new Performance(
				category, 
				title, 
				conductor, 
				collaborator, 
				programs, 
				introduction, 
				programNote, 
				relatedPackage, 
				photo, 
				memo, 
				pfmcDate, 
				pfmctime, 
				location, 
				price, 
				restriction);
		
		//비지니스 로직
		PfmcService pfmcSer = new PfmcServiceImpl();
		pfmcSer.insertPfmc(pfmc);
		
		//다시 공연 목록 페이지로 이동
		response.sendRedirect("/adminPfmc/selectAllPfmcList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
