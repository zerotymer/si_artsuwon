package kr.or.artsuwon.board.model.vo;

import java.sql.Date;

public class Board {
	
	private int boardNo;
	private String subject;
	private String content;
	private Date regDate;
	private int viewCount;
	private char endYN;
	
	
	
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Board(int boardNo, String subject, String content, Date regDate, int viewCount, char endYN) {
		super();
		this.boardNo = boardNo;
		this.subject = subject;
		this.content = content;
		this.regDate = regDate;
		this.viewCount = viewCount;
		this.endYN = endYN;
	}


	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public char getEndYN() {
		return endYN;
	}
	public void setEndYN(char endYN) {
		this.endYN = endYN;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", subject=" + subject + ", content=" + content + ", regDate=" + regDate
				+ ", viewCount=" + viewCount + ", endYN=" + endYN + "]";
	}
	
	
	
}
