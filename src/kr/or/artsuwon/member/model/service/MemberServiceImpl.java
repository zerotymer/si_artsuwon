package kr.or.artsuwon.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.member.model.dao.MemberDAO;
import kr.or.artsuwon.member.model.vo.Member;
import kr.or.artsuwon.member.model.vo.Reservation;

public class MemberServiceImpl implements MemberService {

	
	private MemberDAO mDAO = new MemberDAO();
	
	
	
	@Override
	public Member selectOneMember(String memberId, String memberPwd) {
		
		Connection conn = JDBCTemplate.getConnection();
		Member m = mDAO.selectOneMember(memberId, memberPwd, conn);
		
		JDBCTemplate.close(conn);
		
		return m;
	}


	@Override
	public int insertOneMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.insertOneMember(m, conn);
		
		if(result>0) JDBCTemplate.commit(conn);
		else		 JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}


	@Override
	public boolean selectIdCheck(String memberId) {
		
		Connection conn = JDBCTemplate.getConnection();
		boolean result = mDAO.selectIdCheck(memberId, conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}


	@Override
	public int updateOneMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.updateOneMember(m, conn);
		
		if(result>0) JDBCTemplate.commit(conn);
		else		 JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}


	@Override
	public int deleteOneMember(int memberNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.deleteOneMember(memberNo, conn);
		
		if(result>0) JDBCTemplate.commit(conn);
		else		 JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}


	@Override
	public ArrayList<Reservation> selectMemberReservation(String memberId) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Reservation> list = mDAO.selectMemberReservation(memberId, conn);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}


	@Override
	public int updatePwdMember(String memberId, String pwd, String newPwd) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.updatePwdMember(memberId, pwd, newPwd, conn);
		
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		
		return result;
		
	}

}
