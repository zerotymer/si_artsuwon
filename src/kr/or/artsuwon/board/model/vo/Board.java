package kr.or.artsuwon.board.model.vo;

import java.sql.Date;

public class Board {
	
	private String adminId;
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;

	private int newsNo;
	private String newsTitle;
	private String newsContent;
	
	private int photoNo;
	private String photoTitle;
	private String photoContent;
	private String photoRoute;
	
	private int videoNo;
	private String videoTitle;
	private String videoContent;
	private String videoRoute;
	
	private char endYN;
	private Date regDate;
	private int viewCount;
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(String adminId, int noticeNo, String noticeTitle, String noticeContent, int newsNo, String newsTitle,
			String newsContent, int photoNo, String photoTitle, String photoContent, String photoRoute, int videoNo,
			String videoTitle, String videoContent, String videoRoute, char endYN, Date regDate, int viewCount) {
		super();
		this.adminId = adminId;
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.newsNo = newsNo;
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.photoNo = photoNo;
		this.photoTitle = photoTitle;
		this.photoContent = photoContent;
		this.photoRoute = photoRoute;
		this.videoNo = videoNo;
		this.videoTitle = videoTitle;
		this.videoContent = videoContent;
		this.videoRoute = videoRoute;
		this.endYN = endYN;
		this.regDate = regDate;
		this.viewCount = viewCount;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
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

	public int getNewsNo() {
		return newsNo;
	}

	public void setNewsNo(int newsNo) {
		this.newsNo = newsNo;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public int getPhotoNo() {
		return photoNo;
	}

	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}

	public String getPhotoTitle() {
		return photoTitle;
	}

	public void setPhotoTitle(String photoTitle) {
		this.photoTitle = photoTitle;
	}

	public String getPhotoContent() {
		return photoContent;
	}

	public void setPhotoContent(String photoContent) {
		this.photoContent = photoContent;
	}

	public String getPhotoRoute() {
		return photoRoute;
	}

	public void setPhotoRoute(String photoRoute) {
		this.photoRoute = photoRoute;
	}

	public int getVideoNo() {
		return videoNo;
	}

	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getVideoContent() {
		return videoContent;
	}

	public void setVideoContent(String videoContent) {
		this.videoContent = videoContent;
	}

	public String getVideoRoute() {
		return videoRoute;
	}

	public void setVideoRoute(String videoRoute) {
		this.videoRoute = videoRoute;
	}

	public char getEndYN() {
		return endYN;
	}

	public void setEndYN(char endYN) {
		this.endYN = endYN;
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

	@Override
	public String toString() {
		return "Board [adminId=" + adminId + ", noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", newsNo=" + newsNo + ", newsTitle=" + newsTitle
				+ ", newsContent=" + newsContent + ", photoNo=" + photoNo + ", photoTitle=" + photoTitle
				+ ", photoContent=" + photoContent + ", photoRoute=" + photoRoute + ", videoNo=" + videoNo
				+ ", videoTitle=" + videoTitle + ", videoContent=" + videoContent + ", videoRoute=" + videoRoute
				+ ", endYN=" + endYN + ", regDate=" + regDate + ", viewCount=" + viewCount + "]";
	}

	

	
	
	
	
	
	
	
}
