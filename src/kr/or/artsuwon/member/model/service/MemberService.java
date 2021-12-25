package kr.or.artsuwon.member.model.service;

import kr.or.artsuwon.member.model.vo.Member;

public interface MemberService {

	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2021.12.22
	 * @param userId
	 * @param userPwd
	 * @return Member
	 * Description : 로그인 시 사용하는 메소드
	 */
	public Member selectOneMember(String memberId, String memberPwd);

	/**
	 * 작성자 : 김영주
	 * 작성일 : 2021.12.23
	 * @param m
	 * @return int
	 * Description : 신규 회원 한 명 추가 메소드
	 */
	public int insertOneMember(Member m);

	/**
	 * 작성자 : 김영주
	 * 작성일 : 2021.12.24
	 * @param memberId
	 * @return boolean
	 * Description : 신규 회원 추가 시 아이디 중복 체크 메소드
	 */
	public boolean selectIdCheck(String memberId);

	/**작성자 : 김영주
	 * 작성일 : 2021.12.24
	 * @param m
	 * @return int
	 * Description : 회원 정보 수정 메소드
	 */
	public int updateOneMember(Member m);

}
