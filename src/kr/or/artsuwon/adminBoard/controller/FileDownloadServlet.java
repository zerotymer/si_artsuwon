package kr.or.artsuwon.adminBoard.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminBoard.model.service.BoardAdminService;
import kr.or.artsuwon.adminBoard.model.service.BoardAdminServiceImpl;
import kr.or.artsuwon.adminBoard.model.vo.Notice;



/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/adminNotice/fileDownload.do")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		BoardAdminService bService = new BoardAdminServiceImpl();
		Notice fd = bService.selectFileInfo(noticeNo);
		
		if(fd!=null)
		{
			File file = new File(fd.getFilePath());
			
			response.setContentType("application/octet-stream");	
			response.setContentLength((int)fd.getFileSize());
			
			String fileName = new String(fd.getFileName().getBytes(),"ISO-8859-1");
			
			//인코딩한 파일이름으로 변경해서 전달
			response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			
			//파일 데이터 전달
			FileInputStream fIn = new FileInputStream(file);
			ServletOutputStream out = response.getOutputStream();
	
			byte [] outputByte = new byte[4096];
			
			while(fIn.read(outputByte,0,4086) != -1)
			{
				out.write(outputByte,0,4096);
	
			}	
				
			fIn.close();
			out.flush(); //FLUSH 스트림을 한번 깨끗가게 지움
			out.close();	
				
		}else
		{
			response.sendRedirect("/views/commons/error.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
