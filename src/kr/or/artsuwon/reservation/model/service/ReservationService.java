package kr.or.artsuwon.reservation.model.service;

import kr.or.artsuwon.reservation.model.vo.Reservation;

import java.util.ArrayList;

public interface ReservationService {
    /**
     * 모든 예약 리스트를 반환하는 메소드
     * @param scheduleNo 공연일정
     * @return 예약 리스트
     * @author 신현진
     */
    ArrayList<Reservation> getAllReservationByPerfSchedule(int scheduleNo);
}
