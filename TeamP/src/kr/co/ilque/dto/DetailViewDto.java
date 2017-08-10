package kr.co.ilque.dto;

public class DetailViewDto {
	int boardNo;
	String category;
	String title;
	String contents;
	String writer;
	int buygrade;
	int sellgrade;
	int hits;
	String loc;
	String time;
	String phone;
	int reward;
	String applicant;
	String status;
	String regdate;
	String profilesrc;
	
	
	
	
	public int getBuygrade() {
		return buygrade;
	}

	public void setBuygrade(int buygrade) {
		this.buygrade = buygrade;
	}

	public int getSellgrade() {
		return sellgrade;
	}

	public void setSellgrade(int sellgrade) {
		this.sellgrade = sellgrade;
	}

	
	public DetailViewDto() {
	
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getProfilesrc() {
		return profilesrc;
	}
	public void setProfilesrc(String profilesrc) {
		this.profilesrc = profilesrc;
	}
}
