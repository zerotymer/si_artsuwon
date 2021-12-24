package kr.or.artsuwon.adminBoard.model.vo;

import java.sql.Date;

public class Notice {
    private int noticeNo;
    private String noticeTitle;
    private String noticeContent;
    private Date regDate;
    private int viewCount;
    private char noticeDelYN;
    private int noticePin;
    private String fileName;
    private String fileRename;
    private String filePath;
    private long fileSize;

    public Notice() {
    }

    public Notice(int noticeNo, String noticeTitle, String noticeContent, Date regDate, int viewCount, char noticeDelYN, int noticePin, String fileName, String fileRename, String filePath, long fileSize) {
        this.noticeNo = noticeNo;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.regDate = regDate;
        this.viewCount = viewCount;
        this.noticeDelYN = noticeDelYN;
        this.noticePin = noticePin;
        this.fileName = fileName;
        this.fileRename = fileRename;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }


    public int getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public char getNoticeDelYN() {
        return noticeDelYN;
    }

    public void setNoticeDelYN(char noticeDelYN) {
        this.noticeDelYN = noticeDelYN;
    }

    public int getNoticePin() {
        return noticePin;
    }

    public void setNoticePin(int noticePin) {
        this.noticePin = noticePin;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileRename() {
        return fileRename;
    }

    public void setFileRename(String fileRename) {
        this.fileRename = fileRename;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
