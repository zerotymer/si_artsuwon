package kr.or.artsuwon.performance.model.dao;

import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.common.Tuple;
import kr.or.artsuwon.performance.model.vo.PerformanceInfomation;
import kr.or.artsuwon.performance.model.vo.PerformanceSchedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 신현진
 */
public class PerformanceDAO {


    public ArrayList<PerformanceInfomation> selectAllPerformance(){
        return null;
    }

    public ArrayList<PerformanceInfomation> selectPerformancesByCategory() {
        return null;
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
        return result;
    }



    /**
     * 최근 공연일정을 조회하는 메서드
     * @param conn 연결정보
     * @param count 조회할 공연정보 개수
     * @return 최근 공연정보 리스트
     * @author 신현진
     */
    public ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> selectRecentPrefSchedule(Connection conn, int count) {
        // TOP-N 분석으로 최근 공연정보만 조회 + 오늘 이후
        final String QUERY =
                "SELECT * " +
                "FROM (" +
                    "SELECT * " +
                    "FROM pfmc_schedule " +
                        "LEFT JOIN pfmc USING (pfmc_no) " +
                    "WHERE pfmc_date > SYSDATE " +
                    "ORDER BY pfmc_date DESC) " +
                "WHERE ROWNUM < ?";
        ResultSet rset = null;
        ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> list = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(QUERY)) {
            pstmt.setInt(1, count + 1);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                PerformanceSchedule schedule = new PerformanceSchedule(
                        rset.getInt("SCHEDULE_NO"),
                        rset.getInt("PFMC_NO"),
                        rset.getString("LOCATION"),
                        rset.getString("PRICE"),
                        rset.getDate("PFMC_DATE"),
                        rset.getInt("RESTRICTION")
                );

                PerformanceInfomation info = new PerformanceInfomation(
                        rset.getInt("PFMC_NO"),
                        rset.getString("CATEGORY"),
                        rset.getString("TITLE"),
                        rset.getString("CONDUCTOR"),
                        rset.getString("COLLABORATOR"),
                        rset.getString("PROGRAMS"),
                        rset.getString("INTRODUCTION"),
                        rset.getString("PROGRAM_NOTE"),
                        rset.getString("RELATED_PACKAGE"),
                        rset.getString("PHOTO"),
                        rset.getString("MEMO"),
                        rset.getString("PFMC_STATUS").charAt(0)
                );

                list.add(new Tuple<>(schedule, info));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            // AutoCloseable pstmt
        }

        return list;
    }
}
