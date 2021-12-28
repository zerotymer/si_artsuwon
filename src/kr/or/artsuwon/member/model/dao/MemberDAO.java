package kr.or.artsuwon.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.member.model.vo.Member;
import kr.or.artsuwon.member.model.vo.Reservation;

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

	public int insertOneMember(Member m, Connection conn) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, '00000', ?, SYSDATE, NULL, ?, ?, '0')";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setDate(4, m.getBirthDate());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getAddress());
			pstmt.setString(8, m.getDetailAddress());
			pstmt.setString(9, String.valueOf(m.getGender()));
			pstmt.setString(10, String.valueOf(m.getSmsYN()));
			pstmt.setString(11, String.valueOf(m.getSmsYN()));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public boolean selectIdCheck(String memberId, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset  = null;

		boolean result = false;
		
		String query = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID=?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateOneMember(Member m, Connection conn) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET ADDRESS=?, DETAIL_ADDRESS=?, PHONE=?, EMAIL=?, EMAIL_YN=?, SMS_YN=? WHERE MEMBER_ID=?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getAddress());
			pstmt.setString(2, m.getDetailAddress());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, String.valueOf(m.getEmailYN()));
			pstmt.setString(6, String.valueOf(m.getSmsYN()));
			pstmt.setString(7, m.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteOneMember(int memberNo, Connection conn) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET MEMBER_STATUS='2' WHERE MEMBER_NO=?";
		System.out.println("탈퇴된 회원 Member_NO : "+ memberNo);
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Reservation> selectMemberReservation(String memberId, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		
		String query = "SELECT RESERVATION.*, PFMC.TITLE FROM RESERVATION " + 
					   "	LEFT JOIN PFMC ON (RESERVATION.RESERVATION_NO = PFMC.PFMC_NO) " + 
					   "WHERE RESERVATION_ID=? ";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				Reservation reservation = new Reservation();
				
				reservation.setReservationNo(rset.getString("reservationNo"));
				reservation.setPerformanceNo(rset.getInt("performanceNo"));
				reservation.setTitle(rset.getString("title"));
				reservation.setInvoiceNo(rset.getString("invoiceNo"));
				reservation.setPayMethod(rset.getString("payMethod"));
				reservation.setReservationId(rset.getString("reservationId"));
				reservation.setReservationDate(rset.getDate("reservationDate"));
				reservation.setReservationPrice(rset.getInt("reservationPrice"));
				reservation.setSeatCode(rset.getString("seatCode"));
				
				list.add(reservation);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
		
	}

	public int updatePwdMember(String memberId, String pwd, String newPwd, Connection conn) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET MEMBER_PWD=? WHERE MEMBER_ID=? AND MEMBER_PWD=?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, memberId);
			pstmt.setString(3, pwd);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
		
	}

}
