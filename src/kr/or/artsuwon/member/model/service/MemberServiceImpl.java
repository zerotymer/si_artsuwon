package kr.or.artsuwon.member.model.service;

import java.sql.Connection;

import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.member.model.dao.MemberDAO;
import kr.or.artsuwon.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {

	
	private MemberDAO mDAO = new MemberDAO();
	
	
	@Override
	public Member selectOneMember(String memberId, String memberPwd) {
		
		Connection conn = JDBCTemplate.getConnection();
		Member m = mDAO.selectOneMember(memberId, memberPwd, conn);
		
		JDBCTemplate.close(conn);
		
		return m;
	}

}
