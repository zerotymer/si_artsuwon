package kr.or.artsuwon.adminMngm.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import kr.or.artsuwon.adminMngm.model.dao.AdminDAO;
import kr.or.artsuwon.adminMngm.model.vo.Admin;
import kr.or.artsuwon.common.JDBCTemplate;

public class AdminServiceImpl implements AdminService{
	AdminDAO adminDAO = new AdminDAO();
	
	@Override
	public Admin selectOneAdmin(String adminId, String adminPwd) {
		Connection conn = JDBCTemplate.getConnection();
		Admin admin = adminDAO.selectOneAdmin(conn, adminId, adminPwd);
		JDBCTemplate.close(conn);
		
		return admin;
	}

	
	@Override
	public HashMap<String, Object> selectAllSubAdmin(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		//페이지당 보여줄 인원 수 설정
		int recordCountPerPage = 5;
		ArrayList<Admin> adminList = adminDAO.selectAllSubAdmin(conn,currentPage,recordCountPerPage);
		
		//페이지 네비바 개수 1,2,3으로 나오게 설정
		int naviCountPerPage = 3;
		String pageNaviType = "admin";
		String pageNavi = adminDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage,pageNaviType);
		JDBCTemplate.close(conn);
		
		HashMap<String, Object> adminListMap = new HashMap<String, Object>();
		adminListMap.put("pageNavi", pageNavi);
		adminListMap.put("adminList", adminList);
		
		return adminListMap;
	}

	
	@Override
	public int insertOneAdmin(Admin admin) {
		Connection conn = JDBCTemplate.getConnection();
		int resultRow = adminDAO.insertOneAdmin(conn,admin);
		if(resultRow>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		
		return resultRow;
	}


	@Override
	public int deleteAdmin(String adminNo) {
		Connection conn = JDBCTemplate.getConnection();
		int resultRow = adminDAO.deleteAdmin(conn,adminNo);
		if(resultRow>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		
		return resultRow;
	}


	@Override
	public boolean idCheck(String adminId) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = adminDAO.idCheck(conn,adminId);
		JDBCTemplate.close(conn);
		
		return result;
		
	}


	@Override
	public Admin showAdminInfo(int adminNo) {
		Connection conn = JDBCTemplate.getConnection();
		Admin admin = adminDAO.showAdminInfo(conn,adminNo);
		JDBCTemplate.close(conn);
		
		return admin;
	}
}
