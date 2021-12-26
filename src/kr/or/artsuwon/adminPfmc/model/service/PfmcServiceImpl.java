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
		int resultRow = pfmcDAO.deletePfmc(conn, pfmcNo);
		
		if(resultRow>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		return resultRow;
	}
	
	@Override
	public HashMap<String, Object> selectAllPfmc(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		//
		String queryString = null;
		
		//페이지당 보여줄 공연 개수 설정
		int recordCountPerPage = 5;
		ArrayList<Performance> pfmcList = pfmcDAO.selectAllPfmc(conn,currentPage,recordCountPerPage);
		
		//페이지 네비바 개수 설정
		int naviCountPerPage = 3;
		String pageNavi = pfmcDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage,"/adminPfmc/selectAllPfmcList.do",pfmcList,queryString);
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
	public ArrayList<PerformanceSkdl> selectPfmcSkdl(int pfmcNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<PerformanceSkdl> pfmcSkdlList = pfmcDAO.selectPfmcSkdl(conn, pfmcNo);
		JDBCTemplate.close(conn);
		return pfmcSkdlList;
	}

	@Override
	public int updatePfmc(Performance pfmc) {
		Connection conn = JDBCTemplate.getConnection();
		int resultRow = pfmcDAO.updatePfmc(conn, pfmc);
		if(resultRow>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		return resultRow;
	}

	@Override
	public int insertPfmcSkdl(PerformanceSkdl pfmcSkdl) {
		//ajax로 공연 스케줄 추가시 사용
		Connection conn = JDBCTemplate.getConnection();
		int resultRow = pfmcDAO.insertPfmcSkdl(conn, pfmcSkdl);
		if(resultRow>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		return resultRow;
	}

	@Override
	public int deletePfmcSkdl(int scheduleNo) {
		Connection conn = JDBCTemplate.getConnection();
		int resultRow = pfmcDAO.deletePfmcSkdl(conn, scheduleNo);
		if(resultRow>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		return resultRow;
	}

	@Override
	public HashMap<String, Object> searchPfmc(int currentPage, String srchDate, String srchCategory, String srchPfmcName, String queryString) {
		Connection conn = JDBCTemplate.getConnection();
		
		//페이지당 검색 결과 개수
		int recordCountPerPage = 5;
		ArrayList<Performance> pfmcList = pfmcDAO.searchPfmc(conn,srchDate,srchCategory,srchPfmcName,currentPage,recordCountPerPage);
		
		//검색 결과 페이지 네비바 개수
		int naviCountPerPage = 3;
		String pageNavi = pfmcDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage,"/adminPfmc/searchPfmc.do",pfmcList,queryString);
		
		JDBCTemplate.close(conn);
		
		HashMap<String, Object> pfmcListMap = new HashMap<String, Object>();
		pfmcListMap.put("pageNavi", pageNavi);
		pfmcListMap.put("pfmcList", pfmcList);
		
		return pfmcListMap;
	}
}
