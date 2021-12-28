package kr.or.artsuwon.adminMember.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.csBoard.vo.csBoard;
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
				
				m.setMemberNo(rset.getInt("member_No"));
				m.setMemberId(rset.getString("member_Id"));
				m.setMemberName(rset.getString("member_Name"));
				m.setEmail(rset.getString("email"));
				m.setAddress(rset.getString("address"));
				m.setPhone(rset.getString("phone"));
				m.setEmailYN(rset.getString("email_YN").charAt(0));
				m.setSmsYN(rset.getString("sms_YN").charAt(0));
				m.setMemberStatus(rset.getString("member_Status").charAt(0));
				m.setEnrollDate(rset.getDate("enroll_Date"));
				
				
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
			query = "SELECT * FROM MEMBER WHERE member_status='0'"; 
		}
		
		return query;
	}

	public ArrayList<csBoard> selectSearchPostList(Connection conn, int currentPage, int recordCountPerPage,
			String keyword, String type) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<csBoard> list = new ArrayList<csBoard>();
		
	
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		String query ="";
		
		switch(type)
		{
		case "memberId" : 
			query = " SELECT * " + 
					"FROM (" + 
					"    SELECT ROW_NUMBER() OVER(ORDER BY cs_No DESC) AS NUM, CS.*, member.member_name " + 
					"    FROM CS LEFT JOIN MEMBER ON (CS.CS_WRITER=MEMBER.MEMBER_ID) " + 
					"    WHERE MEMBER.MEMBER_STATUS='0' " + 
					"        AND MEMBER_ID LIKE ?) " + 
					"WHERE NUM BETWEEN ? AND ? " + 
					"ORDER BY NUM ASC";
				break;
		case "memberName" :
			query = " SELECT * " + 
					"FROM (" + 
					"    SELECT ROW_NUMBER() OVER(ORDER BY cs_No DESC) AS NUM, CS.*, member.member_name " + 
					"    FROM CS LEFT JOIN MEMBER ON (CS.CS_WRITER=MEMBER.MEMBER_ID) " + 
					"    WHERE MEMBER.MEMBER_STATUS='0' " + 
					"        AND MEMBER_NAME LIKE ?) " + 
					"WHERE NUM BETWEEN ? AND ? " + 
					"ORDER BY NUM ASC";
				break;
			
		}
		//select * from board order by boardno desc; => 최신글부터 볼 수 있음
		//select * from board where boardno between 108 and 104 order by boardno desc; 
		//=> 최신글부터 원하는 페이지 당 보여지는 수인 5에 맞춰서 5개 볼 수 있다. 단 이건 정확히 boardNo를 알 때의 이야기.
		//인라인 뷰를 사용한다.
		//select * from (select Row_Number() over(order by boardNo desc) as num,board.* from board);
		//()안의 쿼리를 이용해서 가상의 테이블을 만들어놓고 boardNo를 내림차순으로 해서 순위를 만들어 놓은것.
		//그리고 그 순위를 num으로 지정해서 별칭을 붙인것.
		//select * from (select Row_Number() over(order by boardNo desc) as num,board.* from board) where num <=5;
		//=>최상위 5개까지 보여줘라.=>topN분석.
		//select * from (select Row_Number() over(order by boardNo desc) as num,board.* from board) where num between 1 and 5;
		//=>1에서부터 5번째까지. 6~10까지면 2페이지.
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
				pstmt.setString(1, "%" + keyword + "%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next())
			{
				csBoard csBoard =new csBoard();
				
				csBoard.setCsNo(rset.getInt("cs_No"));
				csBoard.setCsTitle(rset.getString("cs_Title"));
				csBoard.setCsContent(rset.getString("cs_Content"));
				csBoard.setCsDate(rset.getDate("cs_Date"));
				csBoard.setCsTypeCode(rset.getString("cs_Type_Code"));
				csBoard.setCsDelYN(rset.getString("cs_Del_YN").charAt(0));
				csBoard.setCsWriter(rset.getString("cs_Writer"));
				csBoard.setAnswerContents(rset.getString("answer_Contents"));
				csBoard.setAnswerWriter(rset.getString("answer_Writer"));
				csBoard.setPrivateYN(rset.getString("private_YN").charAt(0));
				csBoard.setCsPassword(rset.getString("cs_Password"));
				
				list.add(csBoard);
				
				
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

	public String getSearchPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage,
			String keyword, String type) {
		
		int recordTotalCount = totalSearchCount(conn,keyword,type); //검색된 전체 글 개수
		/*System.out.println(recordTotalCount);*/
		
		int pageTotalCount = 0; // 전체 페이지 개수
		
		

		if((recordTotalCount % recordCountPerPage) > 0)
		{
			pageTotalCount = (recordTotalCount / recordCountPerPage) +1;
		}else
		{
			pageTotalCount = (recordTotalCount / recordCountPerPage);
		}
		
		
		
		int startNavi = (((currentPage-1) / naviCountPerPage) * naviCountPerPage) +1;
		int endNavi = startNavi + (naviCountPerPage-1);
		
		
		if(endNavi> pageTotalCount)
		{
			endNavi = pageTotalCount;
		}
		
		//PageNavi 모양 만들기
		StringBuilder sb = new StringBuilder();
		
		if(startNavi!=1)
		{
			sb.append("<a href='/admin/adminMemberPostSch.do?currentPage="+(startNavi-1)+"&keyword="+keyword+"&type="+type+"'>< prev</a>   ");
		}
		
		
		
		for(int i = startNavi; i<=endNavi; i++)
		{
			if(i==currentPage) {
				sb.append("<a href='/admin/adminMemberPostSch.do?currentPage="+i+"&keyword="+keyword+"&type="+type+"'><b style='font-size:1.2em'>"+i+"</b></a> ");
			}else
			{
				sb.append("<a href='/admin/adminMemberPostSch.do?currentPage="+i+"&keyword="+keyword+"&type="+type+"'>"+i+"</a> ");
			}
			
		}
		if(endNavi!=pageTotalCount)
		{
			sb.append(" <a href ='/admin/adminMemberPostSch.do?currentPage="+(endNavi+1)+"&keyword="+keyword+"&type="+type+"'>Next ></a> ");
		}
		
		
		
	
		//System.out.println(sb.toString());
		return sb.toString();
		
		
		
		
		
		
	}

	private int totalSearchCount(Connection conn, String keyword, String type) {
		

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		String query ="";
		
		switch(type)
		{
		case "memberId" : 
				query = "SELECT COUNT(*) AS COUNT " + 
						"FROM CS  LEFT JOIN MEMBER ON (CS.CS_WRITER=MEMBER.MEMBER_ID) WHERE MEMBER.MEMBER_STATUS='0' " + 
						"AND MEMBER_ID LIKE ?";
				break;
			
		case "memberName" :
				query = "SELECT COUNT(*) AS COUNT " + 
						"FROM CS  LEFT JOIN MEMBER ON (CS.CS_WRITER=MEMBER.MEMBER_ID) WHERE MEMBER.MEMBER_STATUS='0' " + 
						"AND MEMBER_NAME LIKE ?";
				break;
			
		}
		
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, "%"+keyword+"%");
			
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				count = rset.getInt("count");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		return count;
	}

	public int updateMemberEndYN(int memberNo, char memberStatus, Connection conn) {
		
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET MEMBER_STATUS=? WHERE MEMBER_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, String.valueOf(memberStatus));
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	




}
