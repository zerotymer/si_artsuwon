package kr.or.artsuwon.adminPfmc.model.vo;

public class PerformanceSkdl {
	private int scheduleNo;
	private int pfmcNo;
	private String location;
	private String price;
	private String pfmcDate;
	private String pfmcTime;
	private int restriction;
	
	
	public PerformanceSkdl() {
		super();
	}


	public PerformanceSkdl(int scheduleNo, int pfmcNo, String location, String price, String pfmcDate, String pfmcTime,
			int restriction) {
		super();
		this.scheduleNo = scheduleNo;
		this.pfmcNo = pfmcNo;
		this.location = location;
		this.price = price;
		this.pfmcDate = pfmcDate;
		this.pfmcTime = pfmcTime;
		this.restriction = restriction;
	}


	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public int getPfmcNo() {
		return pfmcNo;
	}

	public void setPfmcNo(int pfmcNo) {
		this.pfmcNo = pfmcNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPfmcDate() {
		return pfmcDate;
	}

	public void setPfmcDate(String pfmcDate) {
		this.pfmcDate = pfmcDate;
	}

	public String getPfmcTime() {
		return pfmcTime;
	}

	public void setPfmcTime(String pfmcTime) {
		this.pfmcTime = pfmcTime;
	}

	public int getRestriction() {
		return restriction;
	}

	public void setRestriction(int restriction) {
		this.restriction = restriction;
	}

	@Override
	public String toString() {
		return "PerformanceSkdl [scheduleNo=" + scheduleNo + ", pfmcNo=" + pfmcNo + ", location=" + location
				+ ", price=" + price + ", pfmcDate=" + pfmcDate + ", pfmcTime=" + pfmcTime + ", restriction="
				+ restriction + "]";
	}
}
