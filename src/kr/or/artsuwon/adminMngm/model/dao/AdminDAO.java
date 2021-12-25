package kr.or.artsuwon.adminMngm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kr.or.artsuwon.adminMngm.model.vo.Admin;
import kr.or.artsuwon.common.JDBCTemplate;

public class AdminDAO {
	public Admin selectOneAdmin(Connection conn, String adminId, String adminPwd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Admin admin = null;
		String sql = "SELECT * FROM ADMIN WHERE ADMIN_ID=? AND ADMIN_PWD=?";
		
		try {
			pstmt =	conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			pstmt.setString(2, adminPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				admin = new Admin();
				admin.setAdminNo(rset.getInt("ADMIN_NO"));
				admin.setAdminId(rset.getString("ADMIN_ID"));
				admin.setAdminPwd(rset.getString("ADMIN_PWD"));
				admin.setAdminName(rset.getString("ADMIN_NAME"));
				admin.setAdminGrantDate(rset.getDate("ADMIN_GRANT_DATE"));
				admin.setSuperAdminYN(rset.getString("SUPER_ADMIN_YN").charAt(0));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return admin;
	}
	

		public ArrayList<Admin> selectAllSubAdmin(Connection conn, int currentPage, int recordCountPerPage) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<Admin> adminList = new ArrayList<Admin>();
			
			//쿼리 row_num 조건에 들어갈 값
			int start = currentPage * recordCountPerPage - (recordCountPerPage-1); 
			int end = currentPage * recordCountPerPage; 
			
			//총 개수(윈도우 함수), 로우넘(윈도우 함수), 페이지에 따른 가져올 게시글
			String sql = "SELECT *"
						+ "FROM ("
							+ "SELECT ROW_NUMBER() OVER(ORDER BY ADMIN_NO) AS NUM"
							+ "       , A.*"
							+ "       , COUNT(*) OVER() AS CNT"
							+ "  FROM ADMIN A"
							+ " WHERE SUPER_ADMIN_YN='N'"
							+ ")"
						+ "WHERE NUM BETWEEN ? AND ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Admin admin = new Admin();
					admin.setNum(rset.getInt("NUM"));
					admin.setAdminNo(rset.getInt("ADMIN_NO"));
					admin.setAdminId(rset.getString("ADMIN_ID"));
					admin.setAdminName(rset.getString("ADMIN_NAME"));
					admin.setAdminGrantDate(rset.getDate("ADMIN_GRANT_DATE"));
					admin.setAdminEmail(rset.getString("ADMIN_EMAIL"));
					admin.setTotalCount(rset.getInt("CNT"));
					adminList.add(admin);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return adminList;
		}
		
		
		public String getPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {
			int TotalRecordCount = totalCount(conn); //전체 개수 (58)
			int TotalPageCount = 0; //전체 개수를 recordPerPage로 나누면 5.8페이지(6페이지)
			
			//전체 개수 (전체 개수를 recordPerPage로 나누면 5.8 -> 6으로 올리기)
			if ((TotalRecordCount % recordCountPerPage) > 0) { 
				TotalPageCount = (TotalRecordCount / recordCountPerPage) + 1;
			} else {
				TotalPageCount = TotalRecordCount / recordCountPerPage;
			}
			
			//네비바 시작과 끝 (예 : <<4,5,6>> 중 4 와 6)
			int startNavi = (((currentPage - 1) / naviCountPerPage) * naviCountPerPage) + 1;
			int endNavi = startNavi + (naviCountPerPage - 1);
			
			//네비바 완전 마지막장
			if(endNavi > TotalPageCount) {
				endNavi = TotalPageCount;
			}
			
			//페이지 네비바
			String pageNaviUrl = "/adminMngm/selectAllSubAdminList.do";
			
			StringBuilder sb = new StringBuilder();
			if(startNavi != 1) {
				sb.append(
					"<li class=\"page-item\">"
					+ "<a class=\"page-link\" href='" + pageNaviUrl + "?currentPage=" + (startNavi-1) + "' aria-label=\"Previous\">"
					+ "<span aria-hidden=\"true\">«</span>"
					+ "</a>"
					+ "</li>"
					);
				}	
			
			for (int i = startNavi; i <= endNavi; i++) {
				if(i == currentPage) {
					sb.append(
							"<li class=\"page-item active\">"
							+ "<a class=\"page-link\" href='"+ pageNaviUrl + "?currentPage=" + i + "'>" + i + "</a>"
							+ "</li>"
							);
				} else {
					sb.append(
							"<li class=\"page-item\">"
							+ "<a class=\"page-link\" href='" + pageNaviUrl + "?currentPage=" + i + "'>" + i + "</a>"
							+ "</li>"
							);
				}
			}
			
			if (endNavi != TotalPageCount) {
				sb.append(
					"<li class=\"page-item\">"
					+ " <a class=\"page-link\" href='"+ pageNaviUrl +"?currentPage=" + (endNavi+1) + "' aria-label=\"Next\">"
					+ " <span aria-hidden=\"true\">»</span>"
					+ " </a>"
					+ " </li>"
				);
			}
		return sb.toString();
		}


			// 데이터 총 개수 구하는 메서드 따로 작성
			public int totalCount(Connection conn) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				int count = 0;
				
				String sql = "SELECT COUNT(*) AS COUNT FROM ADMIN WHERE SUPER_ADMIN_YN='N'";
				
				try {
					pstmt = conn.prepareStatement(sql);
					rset = pstmt.executeQuery();
					if (rset.next()) {
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


		
		public int insertOneAdmin(Connection conn, Admin admin) {
			PreparedStatement pstmt = null;
			int resultRow = 0;
			
			String sql = "INSERT INTO ADMIN VALUES(ADMIN_SEQ.NEXTVAL,?,?,?,SYSDATE,'N',?)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, admin.getAdminId());
				pstmt.setString(2, admin.getAdminPwd());
				pstmt.setString(3, admin.getAdminName());
				pstmt.setString(4, admin.getAdminEmail());
				resultRow = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return resultRow;
		}


		public int deleteAdmin(Connection conn, String adminNo) {
			PreparedStatement pstmt = null;
			int resultRow = 0;
			
			String sql = "DELETE FROM ADMIN WHERE ADMIN_NO=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, adminNo);
				resultRow = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
			return resultRow;
		}


		public boolean idCheck(Connection conn, String adminId) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			boolean result = false;
			
			String sql = "SELECT ADMIN_ID FROM ADMIN WHERE ADMIN_ID=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, adminId);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					result = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return result;
		}


		public Admin showAdminInfo(Connection conn, int adminNo) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Admin admin = null;
			
			String sql = "SELECT ADMIN_ID, ADMIN_NAME, ADMIN_EMAIL FROM ADMIN WHERE ADMIN_NO=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, adminNo);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					admin = new Admin();
					admin.setAdminId(rset.getString("ADMIN_ID"));
					admin.setAdminName(rset.getString("ADMIN_NAME"));
					admin.setAdminEmail(rset.getString("ADMIN_EMAIL"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return admin;
		}


		public int updateAdminInfo(Connection conn, Admin admin) {
			PreparedStatement pstmt = null;
			int resultRow = 0;
			
			String sql = "UPDATE ADMIN SET ADMIN_NAME=?, ADMIN_EMAIL=? WHERE ADMIN_ID=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, admin.getAdminName());
				pstmt.setString(2, admin.getAdminEmail());
				pstmt.setString(3, admin.getAdminId());
				
				resultRow = pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
			return resultRow;
			
		}


		public int updateAdminPwd(Connection conn, int adminNo, String currentPwd, String newPwd) {
			PreparedStatement pstmt = null;
			int resultRow = 0;
			
			String sql = "UPDATE ADMIN SET ADMIN_PWD=? WHERE ADMIN_NO=? AND ADMIN_PWD=? ";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newPwd);
				pstmt.setInt(2, adminNo);
				pstmt.setString(3, currentPwd);
				resultRow = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
			return resultRow;
		}
}
