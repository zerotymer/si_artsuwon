package kr.or.artsuwon.board.model.dao;

import java.sql.Date;

public class csBoard {
	
	private int csNo;
	private String csTitle;
	private String csContent;
	private Date csDate;
	private String csTypeCode;
	private char csDelYN;
	private String csWriter;
	private String answerContents;
	private String answerWriter;
	private char privateYN;
	private String csPassword;
	
	
	public csBoard() {
		super();
		// TODO Auto-generated constructor stub
	}


	public csBoard(int csNo, String csTitle, String csContent, Date csDate, String csTypeCode, char csDelYN,
			String csWriter, String answerContents, String answerWriter, char privateYN, String csPassword) {
		super();
		this.csNo = csNo;
		this.csTitle = csTitle;
		this.csContent = csContent;
		this.csDate = csDate;
		this.csTypeCode = csTypeCode;
		this.csDelYN = csDelYN;
		this.csWriter = csWriter;
		this.answerContents = answerContents;
		this.answerWriter = answerWriter;
		this.privateYN = privateYN;
		this.csPassword = csPassword;
	}


	@Override
	public String toString() {
		return "csBoard [csNo=" + csNo + ", csTitle=" + csTitle + ", csContent=" + csContent + ", csDate=" + csDate
				+ ", csTypeCode=" + csTypeCode + ", csDelYN=" + csDelYN + ", csWriter=" + csWriter + ", answerContents="
				+ answerContents + ", answerWriter=" + answerWriter + ", privateYN=" + privateYN + ", csPassword="
				+ csPassword + "]";
	}


	public int getCsNo() {
		return csNo;
	}


	public void setCsNo(int csNo) {
		this.csNo = csNo;
	}


	public String getCsTitle() {
		return csTitle;
	}


	public void setCsTitle(String csTitle) {
		this.csTitle = csTitle;
	}


	public String getCsContent() {
		return csContent;
	}


	public void setCsContent(String csContent) {
		this.csContent = csContent;
	}


	public Date getCsDate() {
		return csDate;
	}


	public void setCsDate(Date csDate) {
		this.csDate = csDate;
	}


	public String getCsTypeCode() {
		return csTypeCode;
	}


	public void setCsTypeCode(String csTypeCode) {
		this.csTypeCode = csTypeCode;
	}


	public char getCsDelYN() {
		return csDelYN;
	}


	public void setCsDelYN(char csDelYN) {
		this.csDelYN = csDelYN;
	}


	public String getCsWriter() {
		return csWriter;
	}


	public void setCsWriter(String csWriter) {
		this.csWriter = csWriter;
	}


	public String getAnswerContents() {
		return answerContents;
	}


	public void setAnswerContents(String answerContents) {
		this.answerContents = answerContents;
	}


	public String getAnswerWriter() {
		return answerWriter;
	}


	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}


	public char getPrivateYN() {
		return privateYN;
	}


	public void setPrivateYN(char privateYN) {
		this.privateYN = privateYN;
	}


	public String getCsPassword() {
		return csPassword;
	}


	public void setCsPassword(String csPassword) {
		this.csPassword = csPassword;
	}
	
	
	
}
