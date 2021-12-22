package kr.or.artsuwon.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.artsuwon.member.model.vo.Member;

public class MemberDAO {

	public Member selectOneMember(String userId, String userPwd, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member m = null;
		
		String query = "SELECT * FROM WHERE USERID=? AND USERPWD=? AND USERSTATUS='0'";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				
				m = new Member();
				
				/*private int userNo;
				private String userId;
				private String userPwd;
				private String userName;
				private Date birthDate;
				private String email;
				private String phone;
				private String address;
				private String detailAddress;
				private String zipCode;
				private char gender;
				private Date enrollDate;
				private Date withDrawDate;
				private char emailYN;
				private char smsYN;
				private char userStatus;*/
				
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userId"));
				m.setUserPwd(rset.getString("userName"));
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
				m.setUserStatus(rset.getString("userStatus").charAt(0));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
