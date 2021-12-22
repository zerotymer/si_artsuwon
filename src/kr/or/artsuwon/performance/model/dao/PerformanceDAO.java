package kr.or.artsuwon.performance.model.dao;

import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.common.Tuple;
import kr.or.artsuwon.performance.model.common.PerfCategory;
import kr.or.artsuwon.performance.model.vo.PerformanceInfomation;
import kr.or.artsuwon.performance.model.vo.PerformanceSchedule;

import java.sql.*;
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
                    "ORDER BY pfmc_date ASC) " +
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



    /**
     * 최근 공연일정을 조회하는 메서드
     * @param conn 연결정보
     * @param category 조회할 카테고리
     * @return 최근 공연정보 리스트
     * @author 신현진
     */
    public ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> selectRecentPrefSchedule(Connection conn, PerfCategory category) {
        // TOP-N 분석으로 최근 공연정보만 조회 + 오늘 이후
        final String QUERY =
                "SELECT * " +
                "FROM pfmc_schedule " +
                    "LEFT JOIN pfmc USING (pfmc_no) " +
                "WHERE pfmc_date > SYSDATE " +
                    "AND " + category.toQueryString() +
                "ORDER BY pfmc_date ASC";
        ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> list = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(QUERY)) {

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
        } // AutoCloseable rset, pstmt

        return list;
    }
}
