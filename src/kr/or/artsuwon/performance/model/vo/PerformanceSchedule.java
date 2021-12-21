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
    private String memo;                // MEMO: 메모
    private Date performnaceDate;       // PFMC_DATE: 공연일시

    /// CONSTRUCTORs
    public PerformanceSchedule() {
    }

    public PerformanceSchedule(int scheduleNo, int performanceNo, String location, String price, String memo, Date performnaceDate) {
        this.scheduleNo = scheduleNo;
        this.performanceNo = performanceNo;
        this.location = location;
        this.price = price;
        this.memo = memo;
        this.performnaceDate = performnaceDate;
    }

    /// GETTERs
    public int getScheduleNo() { return scheduleNo; }
    public int getPerformanceNo() { return performanceNo; }
    public String getLocation() { return location; }
    public String getPrice() { return price; }
    public String getMemo() { return memo; }
    public Date getPerformnaceDate() { return performnaceDate; }

    /// SETTERs
    public void setScheduleNo(int scheduleNo) { this.scheduleNo = scheduleNo; }
    public void setPerformanceNo(int performanceNo) { this.performanceNo = performanceNo; }
    public void setLocation(String location) { this.location = location; }
    public void setPrice(String price) { this.price = price; }
    public void setMemo(String memo) { this.memo = memo; }
    public void setPerformnaceDate(Date performnaceDate) { this.performnaceDate = performnaceDate; }
}
