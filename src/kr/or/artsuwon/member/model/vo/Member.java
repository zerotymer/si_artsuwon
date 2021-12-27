package kr.or.artsuwon.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private Date birthDate;
	private String email;
	private String phone;
	private String address;
	private String detailAddress;
	private String zipCode;
	private char gender;
	private Date enrollDate;
	private Date withDrawDate;
	private char emailYN;
	private char smsYN;
	private char memberStatus;
	
	
	
	
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2021.12.24
	 * MemberUpdateServlet에 필요한 메소드
	 * @param memberId
	 * @param email
	 * @param phone
	 * @param address
	 * @param detailAddress
	 * @param smsYN
	 */
	public Member(String memberId, String email, String phone, String address, String detailAddress, char smsYN, char emailYN) {
		super();
		this.memberId = memberId;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.detailAddress = detailAddress;
		this.smsYN = smsYN;
		this.emailYN = emailYN;
	}





	/**
	 * 작성자 : 김영주
	 * 작성일 : 2021.12.23
	 * MemberJoinServlet에 필요한 메소드
	 * @param memberName
	 * @param memberId
	 * @param memberPwd
	 * @param birthDate
	 * @param gender
	 * @param address
	 * @param detailAddress
	 * @param phone
	 * @param email
	 * @param smsYN
	 */
	public Member(String memberName, String memberId, String memberPwd, Date birthDate, char gender, 
				  String address, String detailAddress, String phone, String email, char smsYN) {
		super();
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.birthDate = birthDate;
		this.gender = gender;
		this.address = address;
		this.detailAddress = detailAddress;
		this.phone = phone;
		this.email = email;
		this.smsYN = smsYN;
	}

	
	
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Member(int memberNo, String memberId, String memberPwd, String memberName, Date birthDate, String email,
			String phone, String address, String detailAddress, String zipCode, char gender, Date enrollDate,
			Date withDrawDate, char emailYN, char smsYN, char memberStatus) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.birthDate = birthDate;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.detailAddress = detailAddress;
		this.zipCode = zipCode;
		this.gender = gender;
		this.enrollDate = enrollDate;
		this.withDrawDate = withDrawDate;
		this.emailYN = emailYN;
		this.smsYN = smsYN;
		this.memberStatus = memberStatus;
	}
	


	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
				+ memberName + ", birthDate=" + birthDate + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", detailAddress=" + detailAddress + ", zipCode=" + zipCode + ", gender=" + gender
				+ ", enrollDate=" + enrollDate + ", withDrawDate=" + withDrawDate + ", emailYN=" + emailYN + ", smsYN="
				+ smsYN + ", memberStatus=" + memberStatus + "]";
	}



	public int getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getMemberPwd() {
		return memberPwd;
	}



	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public Date getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getDetailAddress() {
		return detailAddress;
	}



	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}



	public String getZipCode() {
		return zipCode;
	}



	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}



	public char getGender() {
		return gender;
	}



	public void setGender(char gender) {
		this.gender = gender;
	}



	public Date getEnrollDate() {
		return enrollDate;
	}



	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}



	public Date getWithDrawDate() {
		return withDrawDate;
	}



	public void setWithDrawDate(Date withDrawDate) {
		this.withDrawDate = withDrawDate;
	}



	public char getEmailYN() {
		return emailYN;
	}



	public void setEmailYN(char emailYN) {
		this.emailYN = emailYN;
	}



	public char getSmsYN() {
		return smsYN;
	}



	public void setSmsYN(char smsYN) {
		this.smsYN = smsYN;
	}



	public char getMemberStatus() {
		return memberStatus;
	}



	public void setMemberStatus(char memberStatus) {
		this.memberStatus = memberStatus;
	}
	
	
	
	
}
