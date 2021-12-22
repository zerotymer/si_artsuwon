package kr.or.artsuwon.member.model.service;

import kr.or.artsuwon.member.model.vo.Member;

public interface MemberService {

	
	/**
	 * 작성자 : 김영주
	 * @param userId
	 * @param userPwd
	 * @return Member
	 * Description : 로그인 시 사용하는 메소드
	 */
	public Member selectOneMember(String memberId, String memberPwd);

}
