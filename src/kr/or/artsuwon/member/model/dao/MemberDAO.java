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
			
				m.setMemberNo(rset.getInt("member_No"));
				m.setMemberId(rset.getString("member_Id"));
				m.setMemberPwd(rset.getString("member_Pwd"));
				m.setMemberName(rset.getString("member_Name"));
				m.setBirthDate(rset.getDate("birthDate"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setDetailAddress(rset.getString("detail_Address"));
				m.setZipCode(rset.getString("zip_Code"));
				m.setGender(rset.getString("gender").charAt(0));
				m.setEnrollDate(rset.getDate("enroll_Date"));
				m.setWithDrawDate(rset.getDate("withDraw_Date"));
				m.setEmailYN(rset.getString("email_YN").charAt(0));
				m.setSmsYN(rset.getString("sms_YN").charAt(0));
				m.setMemberStatus(rset.getString("member_Status").charAt(0));
				
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
