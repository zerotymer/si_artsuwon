package kr.or.artsuwon.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.artsuwon.board.model.dao.BoardDAO;
import kr.or.artsuwon.board.model.vo.Board;
import kr.or.artsuwon.common.JDBCTemplate;

public class BoardServiceImpl implements BoardService{
	
	private BoardDAO bDAO= new BoardDAO();

	@Override
	public HashMap<String, Object> selectAllPostList(int currentPage) {

		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPerPage = 10;
		
		ArrayList<Board> list = bDAO.selectAllPostPageList(conn,currentPage,recordCountPerPage);
		
		
		HashMap<Integer, Integer> commentCount = bDAO.selectCommentCountList(conn,currentPage,recordCountPerPage);
		
		
		
		// 하나의 PageNavi Bar에 보여질 Navi 개수를 설정
		int naviCountPerPage = 5;
		
		String pageNavi = bDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		
		JDBCTemplate.close(conn);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list", list);
		hm.put("pageNavi", pageNavi);
		hm.put("commentCount", commentCount);
		
		return hm;

	}

}
