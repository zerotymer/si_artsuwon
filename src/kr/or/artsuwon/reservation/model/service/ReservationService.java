package kr.or.artsuwon.reservation.model.service;

import kr.or.artsuwon.reservation.model.vo.Reservation;
import kr.or.artsuwon.reservation.model.vo.SeatInfomation;

import java.util.ArrayList;

public interface ReservationService {
    /**
     * 모든 예약 리스트를 반환하는 메소드
     * @param scheduleNo 공연일정
     * @return 예약 리스트
     * @author 신현진
     */
    ArrayList<Reservation> getAllReservationByPerfSchedule(int scheduleNo);

    /**
     * 좌석 정보를 조회하는 메서드
     * @param restriction 제약조건
     * @return 좌석 정보
     * @author 신현진
     */
    ArrayList<SeatInfomation> getAllSeatsByRestriction(int restriction);
}
