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

	public ArrayList<Board> selectAllPostPageList(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt  = null;
		ResultSet rset = null;
		
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		//모든 게시글을 가져오는 Query 구문
		String query = "SELECT NOTICE *" + 
				
				"    ORDER BY BOARDNO DESC";
		
		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				Board board = new Board();
				
				board.setBoardNo(rset.getInt("boardNo"));
				board.setSubject(rset.getString("subject"));
				board.setContent(rset.getString("content"));
				board.setRegDate(rset.getDate("regDate"));
				board.setEndYN(rset.getString("end_yn").charAt(0));
				
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

	public HashMap<Integer, Integer> selectCommentCountList(Connection conn, int currentPage, int recordCountPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

}
