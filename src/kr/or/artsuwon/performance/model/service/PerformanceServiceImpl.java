package kr.or.artsuwon.performance.model.service;

import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.common.Tuple;
import kr.or.artsuwon.performance.model.common.PerfCategory;
import kr.or.artsuwon.performance.model.dao.PerformanceDAO;
import kr.or.artsuwon.performance.model.vo.PerformanceInfomation;
import kr.or.artsuwon.performance.model.vo.PerformanceSchedule;

import java.sql.Connection;
import java.util.ArrayList;

public class PerformanceServiceImpl implements PerformanceService {
    /// FIELDs
    private PerformanceDAO pDAO = new PerformanceDAO();

    /// METHODs

    /**
     * 최근 공연일정을 조회하는 메서드
     * @param count 가져올 개수
     * @return 최근 공연일정 리스트
     * @author 신현진
     */
    @Override
    public ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> getRecentPerformances(int count) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> list = pDAO.selectRecentPrefSchedule(conn, count);
        JDBCTemplate.close(conn);
        return list;
    }

    /**
     * 최근 공연일정을 조회하는 메서드
     * @param category 공연 카테고리
     * @return 최근 공연일정 리스트
     * @author 신현진
     */
    @Override
    public ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> getRecentPerformances(PerfCategory category) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> list = pDAO.selectRecentPrefSchedule(conn, category);
        JDBCTemplate.close(conn);
        return list;
    }


    /**
     * 최근 공연일정을 조회하는 메서드
     * @param date 조회할 월
     * @return 최근 공연일정 리스트
     * @author 신현진
     */
    @Override
    public ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> getRecentPerformancesByMonth(java.util.Date date) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> list = pDAO.selectPrefScheduleByMonth(conn, date);
        JDBCTemplate.close(conn);
        return list;
    }
}
