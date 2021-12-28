package kr.or.artsuwon.member.model.vo;

import java.sql.Date;

/**
 * 예약에 대한 정보를 담는 클래스
 * @author 신현진
 */
public class Reservation {
    /// FIELDs
    private String reservationNo;           // RESERVATION_NO: 예약번호
    private int performanceNo;              // PFMC_NO: 공연번호
    private String title;           		// TITLE: 공연제목
    private String invoiceNo;                  // INVOICE_NO: 결제번호
    private String payMethod;               // PAY_METHOD: 결제방법
    private String  reservationId;          // RESERVATION_ID: 예약자ID
    private Date reservationDate;           // RESERVATION_DATE: 예약일자
    private int reservationPrice;           // RESERVATION_PRICE: 결제금액
    private String seatCode;                // SEAT_CODE: 예약좌석

    /// CONSTRUCTORs
    public Reservation() {}
    public Reservation(String reservationNo, int performanceNo, String title, String invoiceNo, String payMethod, String reservationId, Date reservationDate, int reservationPrice, String seatCode) {
        this.reservationNo = reservationNo;
        this.performanceNo = performanceNo;
        this.title = title;
        this.invoiceNo = invoiceNo;
        this.payMethod = payMethod;
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.reservationPrice = reservationPrice;
        this.seatCode = seatCode;
    }

    /// GETTERs
    public String getReservationNo() { return reservationNo; }
    public int getPerformanceNo() { return performanceNo; }
    public String getTitle() { return title; }
    public String getInvoiceNo() { return invoiceNo; }
    public String getPayMethod() { return payMethod; }
    public String getReservationId() { return reservationId; }
    public Date getReservationDate() { return reservationDate; }
    public int getReservationPrice() { return reservationPrice; }
    public String getSeatCode() { return seatCode; }

    /// SETTERs
    public void setReservationNo(String reservationNo) { this.reservationNo = reservationNo; }
    public void setPerformanceNo(int performanceNo) { this.performanceNo = performanceNo; }
    public void setTitle(String title) { this.title = title; }
    public void setInvoiceNo(String invoiceNo) { this.invoiceNo = invoiceNo; }
    public void setPayMethod(String payMethod) { this.payMethod = payMethod; }
    public void setReservationId(String reservationId) { this.reservationId = reservationId; }
    public void setReservationDate(Date reservationDate) { this.reservationDate = reservationDate; }
    public void setReservationPrice(int reservationPrice) { this.reservationPrice = reservationPrice; }
    public void setSeatCode(String seatCode) { this.seatCode = seatCode; }
}
