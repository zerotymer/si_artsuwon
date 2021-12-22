package kr.or.artsuwon.member.model.service;

import kr.or.artsuwon.member.model.vo.Member;

public interface MemberService {

	/**
	 * 작성자 : 김영주
	 * 작성일 : 2021.12.22
	 * @param userId
	 * @param userPwd
	 * @return Member
	 * Description : 회원 로그인 로직
	 */
	public Member selectOneMember(String userId, String userPwd);

}
