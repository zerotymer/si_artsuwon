package kr.or.artsuwon.adminBoard.controller;



import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.artsuwon.adminBoard.model.service.BoardAdminService;
import kr.or.artsuwon.adminBoard.model.service.BoardAdminServiceImpl;
import kr.or.artsuwon.adminBoard.model.vo.Notice;




@MultipartConfig(
		 
		 fileSizeThreshold = 1024*1024,
		 maxFileSize = 1024*1024,
		 maxRequestSize=1024*1024*5*5			
			)

@WebServlet("/adminNotice/fileUpload.do")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// multipartRequest를 만들기위한 루트 
		String uploadFilePath = request.getServletContext().getRealPath("/upload"); //업로드 경로가져오기
		int uploadFileSizeLimit =1024 * 1024 * 200;  
		String enType ="UTF-8"; //인코딩
		MultipartRequest multi = new MultipartRequest(request,uploadFilePath,uploadFileSizeLimit,enType, new DefaultFileRenamePolicy());
		//
		
		String noticeTitle = multi.getParameter("noticeTitle");
		String noticeContent = multi.getParameter("noticeContent");	
		String fileName = multi.getFilesystemName("file");
		long currentTime = Calendar.getInstance().getTimeInMillis();	//현재시간
		String fileRename = currentTime+"_"+fileName+"_artsuwon"; // 파일이름 재정의  
		
		System.out.println(uploadFilePath);
		
		//	원본파일을 받아와서 파일객체에 담기 
		File file = new File(uploadFilePath+"\\"+fileName);
		file.renameTo(new File(uploadFilePath+"\\"+fileRename)); // 담아온파일을 파일경로에 이름변경
		String newFilePath = uploadFilePath+"\\"+fileRename;
		
		File reFile = new File(newFilePath);
		long fileSize = reFile.length();
		
		System.out.println("파일 사이즈 : " + fileSize);
		
		Notice fd = new Notice();
		fd.setNoticeTitle(noticeTitle);
		fd.setNoticeContent(noticeContent);
		fd.setFileName(fileName);
		fd.setFileRename(fileRename);
		fd.setFilePath(newFilePath);
		fd.setFileSize(fileSize);
	
		
		BoardAdminService bService = new BoardAdminServiceImpl();
		int result = bService.insertFileUpload(fd);
		
		RequestDispatcher view = request.getRequestDispatcher("/adminNotice/adminNoticeAllList.do");
		request.setAttribute("result", result>0);
		view.forward(request, response);
		
		

		
		
	}

		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
