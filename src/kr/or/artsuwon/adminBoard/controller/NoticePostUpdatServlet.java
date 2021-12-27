package kr.or.artsuwon.adminBoard.controller;

import kr.or.artsuwon.adminBoard.model.service.BoardAdminService;
import kr.or.artsuwon.adminBoard.model.service.BoardAdminServiceImpl;
import kr.or.artsuwon.adminBoard.model.vo.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class NoticePostUpdatServlet
 */
@WebServlet("/notice/noticePostUpdate.do")
public class NoticePostUpdatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticePostUpdatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param noticeNo
     * @param noticeNo
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String noticeContent = request.getParameter("noticeContent");
        String noticeTitle = request.getParameter("noticeTitle");

        int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));


        Notice notice = new Notice();
        notice.setNoticeContent(noticeContent);
        notice.setNoticeTitle(noticeTitle);
        notice.setNoticeNo(noticeNo);


        BoardAdminService bService = new BoardAdminServiceImpl();
        int result = bService.updatePost(notice);


        if (result > 0) {
            response.sendRedirect("/notice/noticeOneSelectContent.do?noticeNo=" + noticeNo + "&currentPage=" + currentPage);
        } else {
            response.sendRedirect("/views/adminCommons/error.jsp");
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

