package kr.or.artsuwon.adminMember.service;

import java.util.ArrayList;

import kr.or.artsuwon.member.model.vo.Member;

public interface AdminMemberService {
	public ArrayList<Member> selectAllMemberList(int adminNo);

	public void selectSearchPost(int currentPage, String keyword, String type);
}
