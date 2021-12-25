package kr.or.artsuwon.adminMngm.model.service;

import java.util.HashMap;
import kr.or.artsuwon.adminMngm.model.vo.Admin;
public interface AdminService {
	//관리자 로그인
	public Admin selectOneAdmin(String adminId, String adminPwd);

	//운영진 목록 가져오기
	public HashMap<String, Object> selectAllSubAdmin(int currentPage);

	//운영진 등록하기
	public int insertOneAdmin(Admin admin);

	//운영진 삭제하기
	public int deleteAdmin(String adminNo);

	//운영진 등록시 id 중복 체크
	public boolean idCheck(String adminId);

	//운영진 한명 정보 가져오기 (수정시)
	public Admin showAdminInfo(int adminNo);

	//(최고 관리자가)운영진 정보 수정
	public int updateAdminInfo(Admin admin);

	//일반 운영진 비밀번호 변경
	public int updateAdminPwd(int adminNo, String currentPwd, String newPwd);
}
