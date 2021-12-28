package kr.or.artsuwon.reservation.model.vo;

public class SeatInfomation {
    /// FIELDs
    private String code;                            // 좌석코드
    private char location;                          // 장소분류
    private char grade;                             // 등급정보
    private char specialNeed;                       // 장애인석
    private char restriction;                       // 제약정보 - 코로나등
    private String memo;                            // 메모


    /// CONSTRUCTORs

    public SeatInfomation() {
    }

    public SeatInfomation(String code, char location, char grade, char specialNeed, char restriction, String memo) {
        this.code = code;
        this.location = location;
        this.grade = grade;
        this.specialNeed = specialNeed;
        this.restriction = restriction;
        this.memo = memo;
    }

    /// GETTERs
    public String getCode() { return code; }
    public char getLocation() { return location; }
    public char getGrade() { return grade; }
    public char getSpecialNeed() { return specialNeed; }
    public char getRestriction() { return restriction; }
    public String getMemo() { return memo; }

    /// SETTERs
    public void setCode(String code) { this.code = code; }
    public void setLocation(char location) { this.location = location; }
    public void setGrade(char grade) { this.grade = grade; }
    public void setSpecialNeed(char specialNeed) { this.specialNeed = specialNeed; }
    public void setRestriction(char restriction) { this.restriction = restriction; }
    public void setMemo(String memo) { this.memo = memo; }
}
