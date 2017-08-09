package kr.co.ilque.dto;

public class MemberDto {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String regdate;
	private int buyGrade;
	private int sellGrade;
	private String profileSrc;
	private String phone;
	private String contents;
	private String gender;
	private  String birth;
	
	public MemberDto() {
		super();
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getBuyGrade() {
		return buyGrade;
	}

	public void setBuyGrade(int buyGrade) {
		this.buyGrade = buyGrade;
	}

	public int getSellGrade() {
		return sellGrade;
	}

	public void setSellGrade(int sellGrade) {
		this.sellGrade = sellGrade;
	}

	public String getProfileSrc() {
		return profileSrc;
	}

	public void setProfileSrc(String profileSrc) {
		this.profileSrc = profileSrc;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

}
