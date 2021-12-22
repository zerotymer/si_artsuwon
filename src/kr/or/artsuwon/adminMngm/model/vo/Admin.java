package kr.or.artsuwon.adminMngm.model.vo;

import java.sql.Date;

public class Admin {
	private int num; //로우넘
	private int adminNo;
	private String adminId;
	private String adminPwd;
	private String adminName;
	private Date adminGrantDate;
	private char superAdminYN;
	private String adminEmail;
	private int totalCount; // 운영진 전체 인원수 (윈도우 함수)
	
	
	public Admin() {
		super();
	}
	
	//운영진 등록시 사용
	public Admin(String adminId, String adminPwd, String adminName, String adminEmail) {
		super();
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
	}


	public Admin(int adminNo, String adminId, String adminPwd, String adminName, Date adminGrantDate, char superAdminYN,
			String adminEmail, int totalCount) {
		super();
		this.adminNo = adminNo;
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminName = adminName;
		this.adminGrantDate = adminGrantDate;
		this.superAdminYN = superAdminYN;
		this.adminEmail = adminEmail;
		this.totalCount = totalCount;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Date getAdminGrantDate() {
		return adminGrantDate;
	}

	public void setAdminGrantDate(Date adminGrantDate) {
		this.adminGrantDate = adminGrantDate;
	}

	public char getSuperAdminYN() {
		return superAdminYN;
	}

	public void setSuperAdminYN(char superAdminYN) {
		this.superAdminYN = superAdminYN;
	}
	
	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "Admin [adminNo=" + adminNo + ", adminId=" + adminId + ", adminPwd=" + adminPwd + ", adminName="
				+ adminName + ", adminGrantDate=" + adminGrantDate + ", superAdminYN=" + superAdminYN + ", adminEmail="
				+ adminEmail + ", totalCount=" + totalCount + "]";
	}
}
