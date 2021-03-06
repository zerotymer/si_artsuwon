package kr.or.artsuwon.performance.model.service;

import kr.or.artsuwon.common.Tuple;
import kr.or.artsuwon.performance.model.common.PerfCategory;
import kr.or.artsuwon.performance.model.vo.PerformanceInfomation;
import kr.or.artsuwon.performance.model.vo.PerformanceSchedule;

import java.sql.Connection;
import java.util.ArrayList;

public interface PerformanceService {
    /**
     * 최근 공연일정을 가져옵니다.
     * @param count 가져올 개수
     * @return 최근 공연일정
     * @author 신현진
     */
    ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> getRecentPerformances(int count);

    /**
     * 최근 공연일정을 가져옵니다.
     * @param category 공연 카테고리
     * @return 최근 공연일정
     * @author 신현진
     */
    ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> getRecentPerformances(PerfCategory category);

    /**
     * 특정 월의 공연일정을 가져옵니다.
     * @param date 조회할 월
     * @return 공연일정 리스트
     * @author 신현진
     */
    ArrayList<Tuple<PerformanceSchedule, PerformanceInfomation>> getRecentPerformancesByMonth(java.util.Date date);

    /**
     * 일정번호로 공연정보를 포함하여 공연일정을 가져온다.
     * @param scheduleNo 일정번호
     * @return 공연정보 및 공연일정. 없으면 null
     * @author 신현진
     */
    Tuple<PerformanceSchedule, PerformanceInfomation> getOnePrefByScheduleNo(int scheduleNo);
}