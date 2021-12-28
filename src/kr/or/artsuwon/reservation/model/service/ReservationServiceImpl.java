package kr.or.artsuwon.reservation.model.service;

import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.reservation.model.dao.ReservationDAO;
import kr.or.artsuwon.reservation.model.vo.Reservation;
import kr.or.artsuwon.reservation.model.vo.SeatInfomation;

import java.sql.Connection;
import java.util.ArrayList;

public class ReservationServiceImpl implements ReservationService {
    /// FIELDs
    private ReservationDAO rDAO = new ReservationDAO();


    /**
     * 공연일정에 대한 모든 예약정보를 가져옴
     * @param scheduleNo 공연일정
     * @return 예약정보 리스트
     * @author 신현진
     */
    @Override
    public ArrayList<Reservation> getAllReservationByPerfSchedule(int scheduleNo) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Reservation> list = rDAO.selectAllReservationByPerfSchedule(conn, scheduleNo);
        JDBCTemplate.close(conn);
        return list;
    }

    /**
     * 좌석정보를 조회하는 메서드
     * @param restriction 제약조건
     * @return 좌석정보 리스트
     * @author 신현진
     */
    @Override
    public ArrayList<SeatInfomation> getAllSeatsByRestriction(int restriction) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<SeatInfomation> list = rDAO.selectAllSeatsByRestriction(conn, restriction);
        JDBCTemplate.close(conn);
        return list;
    }

    /**
     * 예약을 추가하는 메서드
     * @param reservation 예약정보
     * @return 성공여부
     * @author 신현진
     */
    @Override
    public boolean insertReservation(Reservation reservation) {
        Connection conn = JDBCTemplate.getConnection();
        int result = rDAO.insertReservation(conn, reservation);

        if(result > 0) JDBCTemplate.commit(conn);
        else JDBCTemplate.rollback(conn);

        JDBCTemplate.close(conn);
        return result > 0;
    }
}
