package kr.or.artsuwon.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
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
	private char userStatus;
	
	
	
	
	
	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", birthDate=" + birthDate + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", detailAddress=" + detailAddress + ", zipCode=" + zipCode + ", gender=" + gender + ", enrollDate="
				+ enrollDate + ", withDrawDate=" + withDrawDate + ", emailYN=" + emailYN + ", smsYN=" + smsYN
				+ ", userStatus=" + userStatus + "]";
	}




	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public Member(int userNo, String userId, String userPwd, String userName, Date birthDate, String email,
			String phone, String address, String detailAddress, String zipCode, char gender, Date enrollDate,
			Date withDrawDate, char emailYN, char smsYN, char userStatus) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
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
		this.userStatus = userStatus;
	}


	
	
	
	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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


	public char getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(char userStatus) {
		this.userStatus = userStatus;
	}
	
	
	
}
