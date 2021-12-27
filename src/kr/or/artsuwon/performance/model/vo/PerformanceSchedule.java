package kr.or.artsuwon.performance.model.vo;

import java.sql.Date;

/**
 * 기본 공연정보에 대한 일정등 세부정보를 저장하는 클래스
 * @author 신현진
 */
public class PerformanceSchedule {
    /// FIELDs
    private int scheduleNo;             // SCHDULE_NO: 일정번호
    private int performanceNo;          // PFMC_NO: 공연번호
    private String location;            // LOCATION: 장소
    private String price;               // PRICE: 가격
    private Date performanceDate;       // PFMC_DATE: 공연일시
    private int restriction;            // RESTRICTION: 제한등급. 0: 비제한. 1: 좌석일부제한

    /// CONSTRUCTORs
    public PerformanceSchedule() {
    }

    public PerformanceSchedule(int scheduleNo, int performanceNo, String location, String price, Date performanceDate) {
        this.scheduleNo = scheduleNo;
        this.performanceNo = performanceNo;
        this.location = location;
        this.price = price;
        this.performanceDate = performanceDate;
        this.restriction = 0;
    }

    public PerformanceSchedule(int scheduleNo, int performanceNo, String location, String price, Date performanceDate, int restriction) {
        this.scheduleNo = scheduleNo;
        this.performanceNo = performanceNo;
        this.location = location;
        this.price = price;
        this.performanceDate = performanceDate;
        this.restriction = restriction;
    }

    /// GETTERs
    public int getScheduleNo() { return scheduleNo; }
    public int getPerformanceNo() { return performanceNo; }
    public String getLocation() { return location; }
    public String getPrice() { return price; }
    public Date getPerformanceDate() { return performanceDate; }
    public int getRestriction() { return restriction; }

    /// SETTERs
    public void setScheduleNo(int scheduleNo) { this.scheduleNo = scheduleNo; }
    public void setPerformanceNo(int performanceNo) { this.performanceNo = performanceNo; }
    public void setLocation(String location) { this.location = location; }
    public void setPrice(String price) { this.price = price; }
    public void setPerformanceDate(Date performanceDate) { this.performanceDate = performanceDate; }
    public void setRestriction(int restriction) { this.restriction = restriction; }
}
