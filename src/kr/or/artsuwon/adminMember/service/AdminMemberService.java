package kr.or.artsuwon.adminMember.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.or.artsuwon.member.model.vo.Member;

public interface AdminMemberService {
	public ArrayList<Member> selectAllMemberList(int adminNo);

	public HashMap<String,Object> selectSearchPost(int currentPage, String keyword, String type);
}
