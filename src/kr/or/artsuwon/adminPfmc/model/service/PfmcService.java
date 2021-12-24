package kr.or.artsuwon.adminPfmc.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.or.artsuwon.adminPfmc.model.vo.Performance;
import kr.or.artsuwon.adminPfmc.model.vo.PerformanceSkdl;

public interface PfmcService {
	//공연 삭제하기
	public int deletePfmc(String pfmcNo);
	
	//전체 공연 목록 가져오기
	public HashMap<String, Object> selectAllPfmc(int currentPage);

	//공연 등록하기
	public int insertPfmc(Performance pfmc);

	//공연 정보 가져오기 (수정시)
	public Performance showPfmcInfo(int pfmcNo);
	
	//공연 스케줄 추가하기 (수정시)
	public void insertPfmcSkdl();

	//공연 스케줄 가져오기 (수정시)
	public ArrayList<PerformanceSkdl> selectPfmcSkdl(int pfmcNo);
}
