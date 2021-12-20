package kr.or.artsuwon.performance.model.vo;

/**
 * 공연에 대한 기본정보를 저장하는 클래스
 * PFMC table
 * @author 신현진
 */
public class PerformanceInfomation {
    /// FIELDs
    private int performanceNo;      // PFMC_NO: 공연번호
    private String category;        // CATEGORY: 공연분류
    private String title;           // TITLE: 공연제목
    private String conductor;       // CONDUCOTR: 지휘자(ID)
    private String collaborator;    // COLLABORATOR: 협연자(ID)
    private String programs;        // PROGRAMS: 프로그램 설명
    private String introduction;    // INTRODUCTION: 공연소개
    private String programNote;     // PROGRAM_NOTE: 프로그램 노트
    private String relatedPackage;  // RELATED_PACKAGE: 연관 패키지
    private String photo;           // PHOTO: 공연사진. 주소
    private String memo;            // MEMO: 공연 기타 정보
    private char status;            // PFMC_STATUS: 공연 상태

    /// CONSTRUCTORs
    public PerformanceInfomation() { }
    public PerformanceInfomation(int performanceNo, String category, String title, String conductor, String collaborator,
                                 String programs, String introduction, String programNote, String relatedPackage,
                                 String photo, String memo, char status) {
        this.performanceNo = performanceNo;
        this.category = category;
        this.title = title;
        this.conductor = conductor;
        this.collaborator = collaborator;
        this.programs = programs;
        this.introduction = introduction;
        this.programNote = programNote;
        this.relatedPackage = relatedPackage;
        this.photo = photo;
        this.memo = memo;
        this.status = status;
    }


    /// GETTERs
    public int getPerformanceNo() { return performanceNo; }
    public String getCategory() { return category; }
    public String getTitle() { return title; }
    public String getConductor() { return conductor; }
    public String getCollaborator() { return collaborator; }
    public String getPrograms() { return programs; }
    public String getIntroduction() { return introduction; }
    public String getProgramNote() { return programNote; }
    public String getRelatedPackage() { return relatedPackage; }
    public String getPhoto() { return photo; }
    public String getMemo() { return memo; }
    public char getStatus() { return status; }
    /// SETTERs


    public void setPerformanceNo(int performanceNo) { this.performanceNo = performanceNo; }
    public void setCategory(String category) { this.category = category; }
    public void setTitle(String title) { this.title = title; }
    public void setConductor(String conductor) { this.conductor = conductor; }
    public void setCollaborator(String collaborator) { this.collaborator = collaborator; }
    public void setPrograms(String programs) { this.programs = programs; }
    public void setIntroduction(String introduction) { this.introduction = introduction; }
    public void setProgramNote(String programNote) { this.programNote = programNote; }
    public void setRelatedPackage(String relatedPackage) { this.relatedPackage = relatedPackage; }
    public void setPhoto(String photo) { this.photo = photo; }
    public void setMemo(String memo) { this.memo = memo; }
    public void setStatus(char status) { this.status = status; }
}

