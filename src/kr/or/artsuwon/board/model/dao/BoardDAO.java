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

	public Board NoticeSelectOnePost(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Board board = null;

		String query = "	SELECT*FROM NOTICE " + 
						"	WHERE NOTICE_NO=? AND NOTICE_DEL_YN='N'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);

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


	
	public ArrayList<Board> NoticeAllPostPageList(Connection conn, int currentPage, int recordCountPerPage,
		String keyword, String type) {
		

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		
		
		int start =  currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		
		String query =" SELECT * " + 
				"	FROM(SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC)AS NUM,NOTICE.* " + 
				"	FROM NOTICE " + 
				"	WHERE NOTICE_DEL_YN='N' AND NOTICE_TITLE LIKE ? " + 
				"	) " + 
				"	WHERE NUM BETWEEN ? AND ?";  
		

		try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				
				rset = pstmt.executeQuery();
				
				while(rset.next())
				{
					Board board = new Board();
					
					board.setNoticeNo(rset.getInt("Notice_No"));
					board.setNoticeTitle(rset.getString("Notice_title"));
					board.setNoticeContent(rset.getString("Notice_content"));
					board.setRegDate(rset.getDate("reg_Date"));
					board.setEndYN(rset.getString("Notice_del_yn").charAt(0));
					
					list.add(board);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
	}
	
	public ArrayList<Board> NewsAllPostPageList(Connection conn, int currentPage, int recordCountPerPage,
			String keyword, String type) {
			

			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<Board> list = new ArrayList<Board>();
			
			
			int start =  currentPage * recordCountPerPage - (recordCountPerPage-1);
			int end = currentPage * recordCountPerPage;
			
			
			String query =" SELECT * " + 
					"	FROM(SELECT ROW_NUMBER() OVER(ORDER BY NEWS_NO DESC)AS NUM,NEWS.* " + 
					"	FROM NEWS " + 
					"	WHERE NEWS_DEL_YN='N' AND NEWS_TITLE LIKE ? " + 
					"	) " + 
					"	WHERE NUM BETWEEN ? AND ?";  
			

			try {
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, "%"+keyword+"%");
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
					
					rset = pstmt.executeQuery();
					
					while(rset.next())
					{
						Board board = new Board();
						
						board.setNewsNo(rset.getInt("News_No"));
						board.setNewsTitle(rset.getString("News_title"));
						board.setNewsContent(rset.getString("News_content"));
						board.setRegDate(rset.getDate("news_Date"));
						board.setEndYN(rset.getString("news_del_yn").charAt(0));
						
						list.add(board);
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return list;
			
		}



	public String NoticeSearchPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage,
			String keyword, String type) {
		
			int recordTotalCount = noticeTotalSearchCount(conn,keyword,type); //전체 글 개수
	
			int pageTotalCount = 0; // 전체 페이지 개수
			
			pageTotalCount = (int)Math.ceil(recordTotalCount/(double)recordCountPerPage);

			int startNavi = (((currentPage-1) / naviCountPerPage) * naviCountPerPage) + 1;
			
			int endNavi = startNavi + (naviCountPerPage-1);
			
		
			if(endNavi > pageTotalCount)
			{
				endNavi = pageTotalCount;
			}
			
			// PageNavi 모양 만들기
			
			StringBuilder sb = new StringBuilder();
			
			if(startNavi!=1)
			{
				sb.append("<a class='prev' href='/board/NoticePostSearch.do?currentPage="+(startNavi-1)+"&keyword="+keyword+"'> < </a>");
			}else
			{
				sb.append("<a class='prev' href='/board/NoticePostSearch.do?currentPage="+(startNavi-1)+"&keyword="+keyword+"'> < </a>	");
			}
			
			for(int i=startNavi; i<=endNavi;i++)
			{
				if(i==currentPage)
				{
					sb.append("<a href='/board/NoticePostSearch.do?currentPage="+i+"&keyword="+keyword+"'><B style='font-size:1.2em'>"+i+"</B></a> ");
				}else
				{
					sb.append("<a  href='/board/NoticePostSearch.do?currentPage="+i+"&keyword="+keyword+"'>"+i+"</a> ");
				}
				
			}
			
			if(endNavi!=pageTotalCount)
			{
				sb.append(" <a class='next' href='/board/NoticePostSearch.do?currentPage="+(endNavi+1)+"&keyword="+keyword+"'> > </a> ");
			}else
			{
				sb.append(" <a class='next' href='/board/NoticePostSearch.do?currentPage="+(endNavi+1)+"&keyword="+keyword+"'> > </a> ");
			}
			
			
			
			return sb.toString();
}



	private int noticeTotalSearchCount(Connection conn, String keyword, String type) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
		String query ="SELECT COUNT(*) AS COUNT FROM NOTICE " + 
				"	WHERE NOTICE_DEL_YN='N' AND NOTICE_TITLE LIKE ?";
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%"+keyword+"%");

			rset=pstmt.executeQuery();
			
			if(rset.next())
			{
				count = rset.getInt("count");
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return count;
	}

	
	public ArrayList<Board> NewsSelect(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();

		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;

		// 모든 게시글을 가져오는 Query 구문
		String query = " SELECT * " +
				"	FROM(SELECT ROW_NUMBER() OVER(order BY NEWS_NO DESC)AS NUM,NEWS.* " +
				"	FROM NEWS) " + "	WHERE NUM BETWEEN ? AND ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();

				board.setNewsNo(rset.getInt("NEWS_NO"));
				board.setNewsTitle(rset.getString("News_title"));
				board.setRegDate(rset.getDate("NEWS_DATE"));
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
						"<a href='/board/NewsAllSelect.do?currentPage="+ i + "'><B style='font-size:2em'>" + i + "</B></a> ");
			} else {
				sb.append("<a href='/board/NewsAllSelect.do?currentPage=" + i + "'>" + i + "</a> ");
			}

		}

		if (endNavi != pageTotalCount) {
			sb.append(" <a href='/board/NewsAllSelect.do?currentPage=" + (endNavi + 1) + "'>Next ></a> ");
		} else {
			sb.append(" <a href='/board/NewsAllSelect.do?currentPage=" + (endNavi + 1) + "'>Next ></a> ");
		}

		return sb.toString();

	}



	public String newsGetPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {
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
			sb.append("<a class='prev' href='/board/NewsAllSelect.do?currentPage="+(startNavi-1)+"'> < </a>	");
		}else
		{
			sb.append("<a class='prev' href='/board/NewsAllSelect.do?currentPage="+(startNavi-1)+"'> < </a>	");
		}
		
		for(int i=startNavi; i<=endNavi;i++)
		{
			if(i==currentPage)
			{
				sb.append("<a href='/board/NewsAllSelect.do?currentPage="+i+"'><B style='font-size:1.2em'>"+i+"</B></a> ");
			}else
			{
				sb.append("<a  href='/board/NewsAllSelect.do?currentPage="+i+"'>"+i+"</a> ");
			}
			
		}
		
		if(endNavi!=pageTotalCount)
		{
			sb.append(" <a class='next' href='/board/NewsAllSelect.do?currentPage="+(endNavi+1)+"'> > </a> ");
		}else
		{
			sb.append(" <a class='next' href='/board/NewsAllSelect.do?currentPage="+(endNavi+1)+"'> > </a> ");
		}
		
		
		
		return sb.toString();

	}



	public Board newsSelectOnePost(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Board board = null;

		String query = "	SELECT*FROM NEWS " + 
						"	WHERE NEWS_NO=? AND NEWS_DEL_YN='N'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				board = new Board();
				board.setNewsNo(rset.getInt("News_No"));
				board.setNewsTitle(rset.getString("News_title"));
				board.setNewsContent(rset.getString("News_Content"));
				board.setRegDate(rset.getDate("news_date"));


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







	public String NewsSearchPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage,
			String keyword, String type) {
		
		int recordTotalCount = noticeTotalSearchCount(conn,keyword,type); //전체 글 개수

		int pageTotalCount = 0; // 전체 페이지 개수
		
		pageTotalCount = (int)Math.ceil(recordTotalCount/(double)recordCountPerPage);

		int startNavi = (((currentPage-1) / naviCountPerPage) * naviCountPerPage) + 1;
		
		int endNavi = startNavi + (naviCountPerPage-1);
		
	
		if(endNavi > pageTotalCount)
		{
			endNavi = pageTotalCount;
		}
		
		// PageNavi 모양 만들기
		
		StringBuilder sb = new StringBuilder();
		
		if(startNavi!=1)
		{
			sb.append("<a class='prev' href='/board/NewsPostSearch.do?currentPage="+(startNavi-1)+"&keyword="+keyword+"'> < </a>");
		}else
		{
			sb.append("<a class='prev' href='/board/NewsPostSearch.do?currentPage="+(startNavi-1)+"&keyword="+keyword+"'> < </a>	");
		}
		
		for(int i=startNavi; i<=endNavi;i++)
		{
			if(i==currentPage)
			{
				sb.append("<a href='/board/NewsPostSearch.do?currentPage="+i+"&keyword="+keyword+"'><B style='font-size:1.2em'>"+i+"</B></a> ");
			}else
			{
				sb.append("<a  href='/board/NewsPostSearch.do?currentPage="+i+"&keyword="+keyword+"'>"+i+"</a> ");
			}
			
		}
		
		if(endNavi!=pageTotalCount)
		{
			sb.append(" <a class='next' href='/board/NewsPostSearch.do?currentPage="+(endNavi+1)+"&keyword="+keyword+"'> > </a> ");
		}else
		{
			sb.append(" <a class='next' href='/board/NewsPostSearch.do?currentPage="+(endNavi+1)+"&keyword="+keyword+"'> > </a> ");
		}
		
		
		
		return sb.toString();
}



	public int noticePostWrite(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO NOTICE VALUES(notice_Seq.NEXTVAL,?,?,SYSDATE,'N',0,null,null,null,null)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, board.getNoticeTitle());
			pstmt.setString(2, board.getNoticeContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			
		}
		return result;
	}



	public int noticeSearchBoardNo(Connection conn, Board board) {
		PreparedStatement pstmt  = null;
		ResultSet rset = null;
		
		int boardNo = 0;
		
		String query = " SELECT NOTICE_NO FROM  " + 
				"		(SELECT ROW_NUMBER() OVER(order BY NOTICE_NO DESC) AS NUM,NOTICE.*  FROM NOTICE " + 
				"		NOTICE_TITLE=? AND NOTICE_CONTENT=?) " + 
				"		WHERE NUM = 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getNoticeTitle());
			pstmt.setString(2, board.getNoticeContent());
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				boardNo = rset.getInt("boardNo");
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return boardNo;
	}
	
	













	}



