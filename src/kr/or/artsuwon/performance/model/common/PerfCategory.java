package kr.or.artsuwon.performance.model.common;

public enum PerfCategory {
    NONE(0),            // 미지정
    REGUALR(1),         // 정기공연
    CITIZEN(2),         // 시민공연
    TOUR(3),            // 순회공연
    OUTSIDE(4),         // 외부공연
    EDUCATION(5);       // 교육공연

    private final int value;

    PerfCategory(int value) {	this.value = value; }

    public int getValue() { return value; }
    public String toString() {
        switch(this) {
            case NONE:      return "";
            case REGUALR:   return "정기공연";
            case CITIZEN:   return "시민공연";
            case TOUR:      return "순회공연";
            case OUTSIDE:   return "외부공연";
            case EDUCATION: return "교육공연";
        }

        return "";
    }

    public String toQueryString() {
        switch(this) {
            case NONE:      return "1=1 ";
            case REGUALR:   return "category LIKE '정기공연%' ";
            case CITIZEN:   return "category LIKE '시민공연%' ";
            case TOUR:      return "category LIKE '순회공연%' ";
            case OUTSIDE:   return "category LIKE '외부공연%' ";
            case EDUCATION: return "category LIKE '교육공연%' ";
        }

        return "";
    }
}
