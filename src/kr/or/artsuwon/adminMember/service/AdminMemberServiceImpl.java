package kr.or.artsuwon.adminMember.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.or.artsuwon.adminMember.dao.AdminMemberDAO;
import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.member.model.vo.Member;

public class AdminMemberServiceImpl implements AdminMemberService {
	
	private AdminMemberDAO  adDAO = new AdminMemberDAO();
	@Override
	public ArrayList<Member> selectAllMemberList(int adminNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = adDAO.selectAllMemberList(adminNo,conn);
		JDBCTemplate.close(conn);
		
		return list;
	}

}
