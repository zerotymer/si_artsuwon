package kr.or.artsuwon.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.jsp.tagext.PageData;

import kr.or.artsuwon.board.model.dao.BoardDAO;
import kr.or.artsuwon.board.model.vo.Board;
import kr.or.artsuwon.common.JDBCTemplate;

public class BoardServiceImpl implements BoardService{
	
	private BoardDAO bDAO= new BoardDAO();

	@Override
	public HashMap<String,Object> NoticeSelect(int currentPage) {
		
	Connection conn = JDBCTemplate.getConnection();
		
		// 하나의 Page에서 몇개의 목록으로 보여줄 것인지에 대한 값이 필요
		int recordCountPerPage = 10;
		
		ArrayList<Board> list = bDAO.NoticeSelect(conn,currentPage,recordCountPerPage);
		
		
		
		
		// 하나의 PageNavi Bar에 보여질 Navi 개수를 설정
		int naviCountPerPage = 5;
		
		String pageNavi = bDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		
		JDBCTemplate.close(conn);
		
		
		// 2가지 방법
		//1. 별도의 VO를 따로 만들어서 작업하는 방법
		//2. HashMap 을 이용하는 방법
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list", list);
		hm.put("pageNavi", pageNavi);
		
		return hm;
		

	}
	
	@Override
	public Board NoticeSelectOnePost(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		//1개의 게시물을 가져오기 위한 DAO
		Board board = bDAO.NoticeSelectOnePost(conn,boardNo);
		
		JDBCTemplate.close(conn);
		return board;
	}


	
	@Override
	public HashMap<String, Object> NoticeSearchPost(int currentPage, String keyword, String type) {
		Connection conn = JDBCTemplate.getConnection();
		
		//하나의 Page에서 몇개의 목록으로 보여줄것인지에 대한 값이 필요
		int recordCountPerPage=10;
		
		ArrayList<Board> list = bDAO.NoticeAllPostPageList(conn,currentPage,recordCountPerPage,keyword,type);
		
		
		//하나의 PageNavi Bar에 보여줄 Navi 개수를 설정
		int naviCountPerPage=5;
		
		String pageNavi = bDAO.NoticeSearchPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage,keyword,type);
		
		//DB연결 해제
		JDBCTemplate.close(conn);
		
		//리턴을 하기 위하여 HashMap객체를 만들어서 리턴
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("list", list);
		map.put("pageNavi", pageNavi);
		
		return map;
	}
	
	@Override
	public HashMap<String, Object> NewsSearchPost(int currentPage, String keyword, String type) {
		Connection conn = JDBCTemplate.getConnection();
		
		//하나의 Page에서 몇개의 목록으로 보여줄것인지에 대한 값이 필요
		int recordCountPerPage=10;
		
		ArrayList<Board> list = bDAO.NewsAllPostPageList(conn,currentPage,recordCountPerPage,keyword,type);
		
		
		//하나의 PageNavi Bar에 보여줄 Navi 개수를 설정
		int naviCountPerPage=5;
		
		String pageNavi = bDAO.NewsSearchPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage,keyword,type);
		
		//DB연결 해제
		JDBCTemplate.close(conn);
		
		//리턴을 하기 위하여 HashMap객체를 만들어서 리턴
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("list", list);
		map.put("pageNavi", pageNavi);
		
		return map;
	}



	
	@Override
	public HashMap<String,Object> NewsSelect(int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//하나의 Page에서 몇개의 목록으로 보여줄것인지에 대한 값이 필요
		int recordCountPerPage=10;
		
		ArrayList<Board> list = bDAO.NewsSelect(conn,currentPage,recordCountPerPage);
		
		
	
		//하나의 PageNavi Bar에 보여줄 Navi 개수를 설정
		int naviCountPerPage=5;
		
		String PageNavi = bDAO.newsGetPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		JDBCTemplate.close(conn);
		

		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list", list);
		hm.put("PageNavi", PageNavi);
		
		return hm;

	}

	@Override
	public Board NewsSelectOnePost(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		//1개의 게시물을 가져오기 위한 DAO
		Board newsBoard = bDAO.newsSelectOnePost(conn,boardNo);
		
		JDBCTemplate.close(conn);
		return newsBoard;
	}

	@Override
	public int noticePostWrite(Board board) {
		Connection conn = JDBCTemplate.getConnection();
		int result = bDAO.noticePostWrite(conn,board);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public int noticeSearchBoardNo(Board board) {
		Connection conn = JDBCTemplate.getConnection();
		int boardNo = bDAO.noticeSearchBoardNo(conn,board);
		if(boardNo>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.close(conn);
		return 0;
	}





}
