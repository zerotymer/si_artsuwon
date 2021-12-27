package kr.or.artsuwon.adminMember.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.artsuwon.adminMember.service.AdminMemberService;
import kr.or.artsuwon.adminMember.service.AdminMemberServiceImpl;

/**
 * Servlet implementation class UserPostSearchServlet
 */
@WebServlet("/admin/userPostSearch.do")
public class UserPostSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPostSearchServlet() {
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
			
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");
		
		/*System.out.println(keyword);
		System.out.println(type);*/
		//해당 값을 가지고, 비즈니스 로직 처리를 해서 키워드에 해당하는 게시물을 검색하여 페이징처리하여 리턴
		AdminMemberService amService = new AdminMemberServiceImpl();
		HashMap<String,Object> map = amService.selectSearchPost(currentPage,keyword,type);
		//3가지 가지고 가는 이유 currentPage는 페이지 처리하기 위해, 나머지 두개는 DB에서 찾기 위해
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/member_sch_wrote.jsp");
		
		request.setAttribute("pageDataMap", map);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("keyword", keyword);
		
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
