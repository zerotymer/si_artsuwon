package kr.or.artsuwon.adminMember.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminMember.service.AdminMemberService;
import kr.or.artsuwon.adminMember.service.AdminMemberServiceImpl;

/**
 * Servlet implementation class AdminMemberPostSch
 */
@WebServlet("/admin/adminMemberPostSch.do")
public class AdminMemberPostSch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberPostSch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int currentPage;
		
		if(request.getParameter("currentPage")==null)
		{
			//index.jsp에서 게시판으로 이동하는 경우에는 가장 첫 페이지인1page로 셋팅
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//키워드 가지고 오는 코드
		
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword"); //검색한 단어
		String type = request.getParameter("type"); //검색 옵션
		
		//해당 값을 가지고, 비즈니스 로직 처리를 해서 키워드에 해당하는 게시물을 검색하여 페이징처리하여 리턴
		AdminMemberService amService = new AdminMemberServiceImpl();
		amService.selectSearchPost(currentPage,keyword,type);
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
