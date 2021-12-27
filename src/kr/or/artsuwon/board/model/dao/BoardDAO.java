package kr.or.artsuwon.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.artsuwon.board.model.vo.Board;
import kr.or.artsuwon.common.JDBCTemplate;

public class BoardDAO {

	public ArrayList<Board> NoticeSelect(Connection conn, int currentPage, int recordCountPerPage) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();

		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;

		// 모든 게시글을 가져오는 Query 구문
		String query = " SELECT * " +
				"	FROM(SELECT ROW_NUMBER() OVER(order BY NOTICE_NO DESC)AS NUM,NOTICE.* " +
				"	FROM NOTICE) " + "	WHERE NUM BETWEEN ? AND ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();

				board.setNoticeNo(rset.getInt("Notice_No"));
				board.setNoticeTitle(rset.getString("Notice_title"));
				board.setRegDate(rset.getDate("Reg_date"));
				list.add(board);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}
	
	

	public String getPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {

		int recordTotalCount = totalCount(conn); // 전체 글 개수

		int pageTotalCount = 0; // 전체 페이지 개수

		pageTotalCount = (int) Math.ceil(recordTotalCount / (double) recordCountPerPage);

		int startNavi = (((currentPage - 1) / naviCountPerPage) * naviCountPerPage) + 1;
		int endNavi = startNavi + (naviCountPerPage - 1);

		if (endNavi > pageTotalCount) 
		{
			endNavi = pageTotalCount;
		}

		// PageNavi 모양 만들기

		StringBuilder sb = new StringBuilder();
		
		if(startNavi!=1)
		{
			sb.append("<a class='prev' href='/board/NoticeAllSelect.do?currentPage="+(startNavi-1)+"'> < </a>	");
		}else
		{
			sb.append("<a class='prev' href='/board/NoticeAllSelect.do?currentPage="+(startNavi-1)+"'> < </a>	");
		}
		
		for(int i=startNavi; i<=endNavi;i++)
		{
			if(i==currentPage)
			{
				sb.append("<a href='/board/NoticeAllSelect.do?currentPage="+i+"'><B style='font-size:1.2em'>"+i+"</B></a> ");
			}else
			{
				sb.append("<a  href='/board/NoticeAllSelect.do?currentPage="+i+"'>"+i+"</a> ");
			}
			
		}
		
		if(endNavi!=pageTotalCount)
		{
			sb.append(" <a class='next' href='/board/NoticeAllSelect.do?currentPage="+(endNavi+1)+"'> > </a> ");
		}else
		{
			sb.append(" <a class='next' href='/board/NoticeAllSelect.do?currentPage="+(endNavi+1)+"'> > </a> ");
		}
		
		
		
		return sb.toString();

	}
	


	public int totalCount(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int count = 0;

		String query = "SELECT COUNT(*) AS COUNT FROM NOTICE WHERE NOTICE_DEL_YN='N'";

		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			if (rset.next()) 
			{
				count = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return count;
	}

	public Board NoticeSelectOnePost(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Board board = null;

		String query = "	SELECT*FROM NOTICE " + 
						"	WHERE NOTICE_NO=? AND NOTICE_DEL_YN='N'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				board = new Board();
				board.setNoticeNo(rset.getInt("Notice_No"));
				board.setNoticeTitle(rset.getString("Notice_title"));
				board.setNoticeContent(rset.getString("Notice_Content"));
				board.setRegDate(rset.getDate("Reg_date"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return board;
	}


	

	
	
	
	
	
	
	
	
	

	public String NewsPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {

		int recordTotalCount = totalCount(conn); // 전체 글 개수

		int pageTotalCount = 0; // 전체 페이지 개수

		pageTotalCount = (int) Math.ceil(recordTotalCount / (double) recordCountPerPage);

		int startNavi = (((currentPage - 1) / naviCountPerPage) * naviCountPerPage) + 1;
		int endNavi = startNavi + (naviCountPerPage - 1);

		// 만약 공식으로 구한 endNavi가 총 Page 수보다 크다면 총 Page 수로 셋팅하여라 라는 코드
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// PageNavi 모양 만들기

		StringBuilder sb = new StringBuilder();

		if (startNavi != 1) {
			sb.append(
					"<a  href='/board/NewsAllSelect.do?currentPage=" + (startNavi - 1) + "'>< Prev</a>	");
		} else {
			sb.append("<a href='/board/NewsAllSelect.do?currentPage="
					+ (startNavi - 1) + "'>< Prev</a>	");
		}

		for (int i = startNavi; i <= endNavi; i++) {
			if (i == currentPage) {
				sb.append(
						"<a href='/board/NewsAllSelect.do?currentPage="
								+ i + "'><B style='font-size:2em'>" + i + "</B></a> ");
			} else {
				sb.append("<a href='/board/NewsAllSelect.do?currentPage=" + i + "'>" + i + "</a> ");
			}

		}

		if (endNavi != pageTotalCount) {
			sb.append(" <a href='/board/NewsAllSelect.do?currentPage=" + (endNavi + 1) + "'>Next ></a> ");
		} else {
			sb.append(" <a href='/board/NewsAllSelect.do?currentPage="
					+ (endNavi + 1) + "'>Next ></a> ");
		}

		return sb.toString();

	}
	
	public ArrayList<Board> NewsSelect(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();

		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;

		// 모든 게시글을 가져오는 Query 구문
		String query = "SELECT* " + "	FROM(SELECT ROW_NUMBER() OVER(order BY NEWS_NO DESC)AS NUM,NEWS.* "
				+ "	FROM NEWS) " + "	WHERE NUM BETWEEN ? AND ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();

				board.setNewsNo(rset.getInt("NEWS_NO"));
				board.setNewsTitle(rset.getString("News_title"));
				board.setRegDate(rset.getDate("Reg_date"));
				list.add(board);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}



	}



