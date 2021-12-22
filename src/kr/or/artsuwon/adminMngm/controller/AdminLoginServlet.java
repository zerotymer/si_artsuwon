package kr.or.artsuwon.adminMngm.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kr.or.artsuwon.adminMngm.model.service.AdminService;
import kr.or.artsuwon.adminMngm.model.service.AdminServiceImpl;
import kr.or.artsuwon.adminMngm.model.vo.Admin;

@WebServlet("/adminMngm/adminLogin.do")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자 id와 pw 파라미터 받기
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		
		//비지니스 로직 처리
		AdminService adminSer = new AdminServiceImpl();
		Admin admin = adminSer.selectOneAdmin(adminId, adminPwd);
				
		//메인 페이지 이동
		if(admin!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			response.sendRedirect("/views/adminMngm/adminMain.jsp"); 
		}else {
			response.sendRedirect("/views/adminMngm/adminLoginFail.jsp"); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
