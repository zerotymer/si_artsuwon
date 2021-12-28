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
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet("/adminNotice/noticeWrite.do")
public class NoticeWriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String NoticeTitle = request.getParameter("noticeTitle");
        String noticeContent = request.getParameter("noticeContent");


        Notice notice = new Notice();
        notice.setNoticeTitle(NoticeTitle);
        notice.setNoticeContent(noticeContent);

        System.out.println(notice.getNoticeTitle());
        System.out.println(notice.getNoticeContent());

        BoardAdminService bService = new BoardAdminServiceImpl();
        int result = bService.insertPost(notice);

        if (result > 0) {
            int noticeNo = bService.searchNoticeNo(notice);

            response.sendRedirect("/adminNotice/noticeOneSelectContent.do?noticeNo=" + noticeNo + "&currentPage=1");

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
