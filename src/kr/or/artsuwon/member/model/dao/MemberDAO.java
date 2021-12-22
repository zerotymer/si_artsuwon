package kr.or.artsuwon.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.member.model.vo.Member;

public class MemberDAO {

	public Member selectOneMember(String memberId, String memberPwd, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member m = null;
		
		String query = "SELECT * FROM MEMBER WHERE MEMBER_ID=? AND MEMBER_PWD=? AND MEMBER_STATUS='0'";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				
				m = new Member();
			
				m.setMemberNo(rset.getInt("memberNo"));
				m.setMemberId(rset.getString("memberId"));
				m.setMemberPwd(rset.getString("memberPwd"));
				m.setMemberName(rset.getString("memberName"));
				m.setBirthDate(rset.getDate("birthDate"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setDetailAddress(rset.getString("detailAddress"));
				m.setZipCode(rset.getString("zipCode"));
				m.setGender(rset.getString("gender").charAt(0));
				m.setEnrollDate(rset.getDate("enrollDate"));
				m.setWithDrawDate(rset.getDate("withDrawDate"));
				m.setEmailYN(rset.getString("emailYN").charAt(0));
				m.setSmsYN(rset.getString("smsYN").charAt(0));
				m.setMemberStatus(rset.getString("memberStatus").charAt(0));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	}

}
