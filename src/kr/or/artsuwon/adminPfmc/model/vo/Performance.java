package kr.or.artsuwon.adminPfmc.model.vo;

public class Performance {
	private int num; //로우넘
	private int pfmcNo;
	private String category;
	private String title;
	private String conductor;
	private String collaborator;
	private String programs;
	private String introduction;
	private String programNote;
	private String relatedPackage;
	private String photo;
	private String memo;
	private char pfmcStatus;
	private int totalCount; //공연 전체 개수 (윈도우함수)
	//pfmc_schedule 컬럼
	private String pfmcDate;
	private String pfmcTime;
	private String location;
	private String price;
	private int restriction;
	
	
	public Performance() {
		super();
	}
	
	
	//공연 최초 등록시 모든 데이터
	public Performance(String category, String title, String conductor, String collaborator, String programs,
			String introduction, String programNote, String relatedPackage, String photo, String memo, String pfmcDate,
			String pfmcTime, String location, String price, int restriction) {
		super();
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
		this.pfmcDate = pfmcDate;
		this.pfmcTime = pfmcTime;
		this.location = location;
		this.price = price;
		this.restriction = restriction;
	}


	public Performance(String category, String title, String conductor, String collaborator, String programs,
			String introduction, String programNote, String relatedPackage, String memo, String photo) {
		super();
		this.category = category;
		this.title = title;
		this.conductor = conductor;
		this.collaborator = collaborator;
		this.programs = programs;
		this.introduction = introduction;
		this.programNote = programNote;
		this.relatedPackage = relatedPackage;
		this.memo = memo;
		this.photo = photo;
	}

	

	public Performance(int pfmcNo, String category, String title, String conductor, String collaborator,
			String programs, String introduction, String programNote, String relatedPackage, String photo, String memo,
			char pfmcStatus) {
		super();
		this.pfmcNo = pfmcNo;
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
		this.pfmcStatus = pfmcStatus;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}


	public int getPfmcNo() {
		return pfmcNo;
	}

	public void setPfmcNo(int pfmcNo) {
		this.pfmcNo = pfmcNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getConductor() {
		return conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
	}

	public String getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(String collaborator) {
		this.collaborator = collaborator;
	}

	public String getPrograms() {
		return programs;
	}

	public void setPrograms(String programs) {
		this.programs = programs;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getProgramNote() {
		return programNote;
	}

	public void setProgramNote(String programNote) {
		this.programNote = programNote;
	}

	public String getRelatedPackage() {
		return relatedPackage;
	}

	public void setRelatedPackage(String relatedPackage) {
		this.relatedPackage = relatedPackage;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public char getPfmcStatus() {
		return pfmcStatus;
	}

	public void setPfmcStatus(char pfmcStatus) {
		this.pfmcStatus = pfmcStatus;
	}

	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public String getPfmcDate() {
		return pfmcDate;
	}

	public void setPfmcDate(String pfmcDate) {
		this.pfmcDate = pfmcDate;
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

	public int getRestriction() {
		return restriction;
	}

	public void setRestriction(int restriction) {
		this.restriction = restriction;
	}

	public String getPfmcTime() {
		return pfmcTime;
	}


	public void setPfmcTime(String pfmcTime) {
		this.pfmcTime = pfmcTime;
	}


	@Override
	public String toString() {
		return "Performance [num=" + num + ", pfmcNo=" + pfmcNo + ", category=" + category + ", title=" + title
				+ ", conductor=" + conductor + ", collaborator=" + collaborator + ", programs=" + programs
				+ ", introduction=" + introduction + ", programNote=" + programNote + ", relatedPackage="
				+ relatedPackage + ", photo=" + photo + ", memo=" + memo + ", pfmcStatus=" + pfmcStatus
				+ ", totalCount=" + totalCount + ", pfmcDate=" + pfmcDate + ", pfmcTime=" + pfmcTime
				+ ", location=" + location + ", price=" + price + ", restriction=" + restriction + "]";
	}

}
