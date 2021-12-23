package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import vo.Notice;

public class BoardDAO {
	


	public ArrayList<Notice> selectAllPostPageList(Connection conn, int currentPage, int recordCountPerPage) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		int start = currentPage * recordCountPerPage -(recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		String query = "SELECT *" + 
				"FROM(SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC)" + 
				"AS NUM, NOTICE.* FROM NOTICE WHERE NOTICE_DEL_YN='N') " + 
				"WHERE NUM BETWEEN ? AND ?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{		
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				notice.setRegDate(rset.getDate("REG_DATE"));
				notice.setNoticeDelYN(rset.getString("NOTICE_DEL_YN").charAt(0));
				notice.setNoticePin(rset.getInt("NOTICE_PIN"));
				notice.setFileName(rset.getString("FILE_NAME"));
				notice.setFileRename(rset.getString("FILE_RENAME"));
				notice.setFilePath(rset.getString("FILE_PATH"));
				notice.setFileSize(rset.getInt("FILE_SIZE"));
				
				list.add(notice);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
		
	}
	
	
	public int totalCount(Connection conn)
	{// 총페이지 찾기 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
		String query = "SELECT COUNT(*) as count FROM NOTICE WHERE NOTICE_DEL_YN='N'";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		return count;
	}
	
	
	public String getPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {
		int recordTotalCount = totalCount(conn); // 전체 글개수 
		 
		int pageTotalCount = 0; // 전체 페이지 개수
		
		/*if(recordTotalCount % recordCountPerPage > 0 ) 
		{
			pageTotalCount = (recordTotalCount / recordCountPerPage) + 1;
		}else
		{
			pageTotalCount = (recordTotalCount / recordCountPerPage);
		}
		*/
		pageTotalCount = (int)Math.ceil(recordTotalCount/(double)recordCountPerPage);
		
		int startNavi = (((currentPage-1)/naviCountPerPage) * naviCountPerPage)+1;
		int endNavi = startNavi + (naviCountPerPage-1);
		
		 StringBuilder sb = new StringBuilder();
		 
		 if(endNavi > pageTotalCount)
			{
				endNavi = pageTotalCount;
			}
		 
		 
	        if(startNavi==1) {

	            sb.append("<li class='page-item disabled'><span class='page-link'' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span>"+
	               	  "</span></li>");

	        }else
	        {
	        sb.append("<li class='page-item'><a class='page-link text-dark'" + 
	                "href='/notice/adminNoticeAllList.do?currentPage="+(startNavi-1)+"' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span>" + 
	                "</a></li>");
	        }

	        for(int i=startNavi; i<=endNavi; i++)
	        {
	            if(i==currentPage)
	            {
	                sb.append("<li class='page-item active' aria-current='page'>" + 
	                        "<a class='page-link' href='/notice/adminNoticeAllList.do?currentPage="+i+"'>"+i+"</a></li>");
	            }else
	            {
	                sb.append("<li class='page-item'><a class='page-link text-dark' href='/notice/adminNoticeAllList.do?currentPage="+i+"'>"+i+"</a></li>");
	            }

	        }

	        if(endNavi==pageTotalCount)
	        {
	            sb.append("<li class='page-item disabled'><span class='page-link'" + 
	                    "aria-label='Next'> <span aria-hidden='true'>&raquo;</span>" + 
	                    "</span></li>");
	        }else
	        {
	            sb.append("<li class='page-item'><a class='page-link text-dark'" + 
	                "href='/notice/adminNoticeAllList.do?currentPage="+(endNavi+1)+"' aria-label='Next'> <span aria-hidden='true'>&&raquo;</span>" + 
	                "</a></li>");
	        }


			return sb.toString();		
		
		}


	public Notice selectOneContent(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Notice notice = null;
		
		String query = "SELECT * FROM NOTICE WHERE NOTICE_NO=? and NOTICE_DEL_YN='N'";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
			notice = new Notice();	
			notice.setNoticeNo(rset.getInt("NOTICE_NO"));
			notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
			notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
			notice.setRegDate(rset.getDate("REG_DATE"));
			notice.setViewCount(rset.getInt("View_Count"));
			notice.setFileName(rset.getString("FILE_NAME"));
			notice.setFileRename(rset.getString("FILE_RENAME"));
			notice.setFilePath(rset.getString("FILE_PATH"));
			notice.setFileSize(rset.getInt("FILE_SIZE"));	
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return notice;
	}


	
	
	
	public int updatePost(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = "UPDATE NOTICE SET NOTICE_CONTENT=?, NOTICE_TITLE=? WHERE NOTICE_NO=?";
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeContent());
			pstmt.setString(2, notice.getNoticeTitle());
			pstmt.setInt(3, notice.getNoticeNo());	
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCTemplate.close(pstmt);
		}
		return -1;
	}


	public int insertPost(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query ="INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL,?,?,SYSDATE,0,'N',0,null,null,null,null)"; 
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
		
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	public int searchNoticeNo(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int noticeNo = 0;
		
		String query = "SELECT NOTICE_NO FROM(SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC)" + 
				"AS NUM, NOTICE.* FROM NOTICE WHERE NOTICE_TITLE=? AND NOTICE_CONTENT=?)"+ 
				"WHERE NUM = 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				noticeNo = rset.getInt("notice_No");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return noticeNo;
	}


	public int deletePost(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE NOTICE SET NOTICE_DEL_YN='Y' WHERE NOTICE_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			result =pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public ArrayList<Notice> selectSearchPostList(Connection conn, int currentPage, int recordCountPerPage,
			String keyword, String type) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		int start = currentPage * recordCountPerPage -(recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		String query ="";
		
		
		switch(type)
		{
		case "noticeTitle":
			 query = "SELECT *" + 
						"FROM(SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC)" + 
						"AS NUM, NOTICE.* FROM NOTICE WHERE NOTICE_DEL_YN='N' AND  NOTICE_TITLE=?) " + 
						"WHERE NUM BETWEEN ? AND ?";
			 
			 break;
			
		case "noticeContent" :
			 query = "SELECT *" + 
						"FROM(SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC)" + 
						"AS NUM, NOTICE.* FROM NOTICE WHERE NOTICE_DEL_YN='N' AND NOTICE_CONTENT=?) " + 
						"WHERE NUM BETWEEN ? AND ?";
			 
			 break;
		case "all" : 
			
			 query = "SELECT *" + 
						"FROM(SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC)" + 
						"AS NUM, NOTICE.* FROM NOTICE WHERE NOTICE_DEL_YN='N' AND "
						+ "(NOTICE_TITLE LIKE? OR NOTICE_CONTENT=?) " + 
						"WHERE NUM BETWEEN ? AND ?";	
			 
			 break;
			 
		}
		
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			if(type.equals("all"))
			{
				pstmt.setString(1, keyword);
				pstmt.setString(2, keyword);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
			}else
			{
				pstmt.setString(1, keyword);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{		
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				notice.setRegDate(rset.getDate("REG_DATE"));
				notice.setNoticeDelYN(rset.getString("NOTICE_DEL_YN").charAt(0));
				notice.setNoticePin(rset.getInt("NOTICE_PIN"));
				notice.setFileName(rset.getString("FILE_NAME"));
				notice.setFileRename(rset.getString("FILE_RENAME"));
				notice.setFilePath(rset.getString("FILE_PATH"));
				notice.setFileSize(rset.getInt("FILE_SIZE"));
				
				list.add(notice);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
		
	}




	
		
}
		
	
	
	


