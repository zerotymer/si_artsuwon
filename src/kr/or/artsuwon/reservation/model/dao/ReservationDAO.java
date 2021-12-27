package kr.or.artsuwon.reservation.model.dao;

import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.reservation.model.vo.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDAO {

    /**
     * 공연일정으로 모든 예약정보를 조회하는 메서드
     * @param conn 연결정보
     * @param scheduleNo  공연일정번호
     * @return 예약정보 리스트
     * @author 신현진
     */
    public ArrayList<Reservation> selectAllReservationByPerfSchedule(Connection conn, int scheduleNo) {
        final String QUERY = "SELECT * FROM reservation WHERE schedule_no = ? ";
        ResultSet rset = null;
        ArrayList<Reservation> list = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(QUERY)) {
            pstmt.setInt(1, scheduleNo);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                Reservation reservation = new Reservation(
                    rset.getString("reservation_no"),
                    rset.getInt("pfmc_no"),
                    rset.getString("invoice_no"),
                    rset.getString("schedule_no"),
                    rset.getString("reservation_id"),
                    rset.getDate("reservation_date"),
                    rset.getInt("reservation_price"),
                    rset.getString("seat_code"));
                list.add(reservation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            // AutoClosable pstmt
        }

        return list;
    }
}
