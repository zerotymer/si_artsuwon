package kr.or.artsuwon.adminPfmc.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.artsuwon.adminPfmc.model.dao.PfmcDAO;
import kr.or.artsuwon.adminPfmc.model.vo.Performance;
import kr.or.artsuwon.adminPfmc.model.vo.PerformanceSkdl;
import kr.or.artsuwon.common.JDBCTemplate;

public class PfmcServiceImpl implements PfmcService{
	PfmcDAO pfmcDAO = new PfmcDAO();
	
	@Override
	public int deletePfmc(String pfmcNo) {
		Connection conn = JDBCTemplate.getConnection();
		int resultRow = PfmcDAO.deletePfmc(conn, pfmcNo);
		
		if(resultRow>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		return resultRow;
	}
	
	@Override
	public HashMap<String, Object> selectAllPfmc(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		//페이지당 보여줄 공연 개수 설정
		int recordCountPerPage = 5;
		ArrayList<Performance> pfmcList = pfmcDAO.selectAllPfmc(conn,currentPage,recordCountPerPage);
		
		//페이지 네비바 개수 설정
		int naviCountPerPage = 3;
		String pageNavi = pfmcDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		JDBCTemplate.close(conn);
		
		HashMap<String, Object> pfmcListMap = new HashMap<String, Object>();
		pfmcListMap.put("pageNavi", pageNavi);
		pfmcListMap.put("pfmcList", pfmcList);
		
		return pfmcListMap;
	}

	@Override
	public int insertPfmc(Performance pfmc) {
		Connection conn = JDBCTemplate.getConnection();
		int resultRow = pfmcDAO.insertPfmc(conn, pfmc);
		
		if(resultRow>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		return resultRow;
	}

	@Override
	public Performance showPfmcInfo(int pfmcNo) {
		Connection conn = JDBCTemplate.getConnection();
		Performance pfmc = pfmcDAO.showPfmcInfo(conn,pfmcNo);
		JDBCTemplate.close(conn);
		
		return pfmc;
	}

	@Override
	public void insertPfmcSkdl() {
		//ajax로 공연 스케줄 추가시 사용
	}

	@Override
	public ArrayList<PerformanceSkdl> selectPfmcSkdl(int pfmcNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<PerformanceSkdl> pfmcSkdlList = pfmcDAO.selectPfmcSkdl(conn, pfmcNo);
		JDBCTemplate.close(conn);
		return pfmcSkdlList;
	}
}
