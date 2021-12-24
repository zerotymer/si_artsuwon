package kr.or.artsuwon.adminMember.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.member.model.vo.Member;

public class AdminMemberDAO {

	public ArrayList<Member> selectAllMemberList(int adminNo, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		String query = selectAllMemberQuery(adminNo);
		
		
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				Member m = new Member();
				
				m.setMemberNo(rset.getInt("memberNo"));
				m.setMemberId(rset.getString("memberId"));
				m.setMemberName(rset.getString("memberName"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setEmailYN(rset.getString("emailYN").charAt(0));
				m.setSmsYN(rset.getString("smsYN").charAt(0));
				m.setMemberStatus(rset.getString("memberStatus").charAt(0));
				
				
				
				list.add(m);
																				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
		
	}

	private String selectAllMemberQuery(int adminNo) {
		
		String query = null;
		if(adminNo==1)
		{
			query = "SELECT * FROM MEMBER"; 
			
		}else
		{
			query = "SELECT * FROM MEMBER WHERE memberStatus='0'"; 
		}
		
		return query;
	}


}
