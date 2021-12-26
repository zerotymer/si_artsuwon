package kr.or.artsuwon.adminPfmc.controller;

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

@WebServlet("/adminPfmc/updatePfmc.do")
public class UpdatePfmcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePfmcServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//모든 공연 정보(동적테이블 제외) + 공연 번호 가져오기
		String uploadFilePath = request.getServletContext().getRealPath("/upload/show");
		int fileSizeLimit = 1024*1024*50;
		String encType="utf-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, fileSizeLimit, encType, new DefaultFileRenamePolicy());
	
		int pfmcNo = Integer.parseInt(multi.getParameter("pfmcNo"));
		String category = multi.getParameter("category");
		String title = multi.getParameter("title");
		String conductor = multi.getParameter("conductor");
		String collaborator = multi.getParameter("collaborator");
		String programs = multi.getParameter("programs");
		String introduction = multi.getParameter("introduction");
		String programNote = multi.getParameter("programNote");
		String relatedPackage = multi.getParameter("relatedPackage");
		String memo = multi.getParameter("memo");
		//새 사진 (서버로 전송될 사진)
		String photo = multi.getFilesystemName("file");
		//기존 사진
		String prevPhoto = multi.getParameter("prevPhoto"); 
		//기존사진이 있어 그리고 새 사진을 등록을 안했어 그러면 기존사진으로 업뎃해
		if(photo==null && prevPhoto != null) {
			photo = prevPhoto;
		}
		
		Performance pfmc = new Performance(
				pfmcNo,
				category,
				title, 
				conductor, 
				collaborator, 
				programs, 
				introduction, 
				programNote,
				relatedPackage, 
				memo, 
				photo);
		
		//비지니스 로직
		PfmcService pfmcSer = new PfmcServiceImpl();
		pfmcSer.updatePfmc(pfmc);
		
		//다시 공연 목록 페이지로 이동
		response.sendRedirect("/adminPfmc/selectAllPfmcList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
