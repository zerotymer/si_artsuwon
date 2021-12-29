package kr.or.artsuwon.adminBoard.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.artsuwon.adminBoard.model.dao.BoardAdminDAO;
import kr.or.artsuwon.adminBoard.model.vo.Notice;
import kr.or.artsuwon.common.JDBCTemplate;



public class BoardAdminServiceImpl implements BoardAdminService{
	private BoardAdminDAO bDAO = new BoardAdminDAO();
	

	
	@Override
	public HashMap<String,Object> selectAllPostList(int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPerPage = 10;
		
		ArrayList<Notice> list = bDAO.selectAllPostPageList(conn, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5; 
		
		String pageNavi = bDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		JDBCTemplate.close(conn);
		
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list",list);
		hm.put("pageNavi", pageNavi);
			
		
		return hm;
	}



	@Override
	public Notice selectOneContent(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice notice = bDAO.selectOneContent(conn, noticeNo);
		JDBCTemplate.close(conn);
		return notice;
		
		
	}



	@Override
	public int updatePost(Notice notice) {
		Connection conn = JDBCTemplate.getConnection();
		int result = bDAO.updatePost(conn,notice);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}



	@Override
	public int insertPost(Notice notice) {
		Connection conn = JDBCTemplate.getConnection();
		int result = bDAO.insertPost(conn,notice);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.close(conn);
		return result;
	}



	@Override
	public int searchNoticeNo(Notice notice) {
		Connection conn = JDBCTemplate.getConnection();
		 int noticeNo = bDAO.searchNoticeNo(conn,notice);
		 JDBCTemplate.close(conn);
		return noticeNo;
	}



	@Override
	public int deletePost(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result =  bDAO.deletePost(conn,noticeNo);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}



	@Override
	public HashMap<String, Object> selectSearchPost(int currentPage, String keyword, String type) {
		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPerPage = 10;
		
		ArrayList<Notice> list = bDAO.selectAllPostPageList(conn, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5; 
		
		String pageNavi = bDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		JDBCTemplate.close(conn);
		
		
		HashMap <String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list",list);
		hm.put("pageNavi", pageNavi);
			
		
		return hm;
	}



	

}
