package kr.co.ilque.dto;

public class BoardReviewDto extends ReviewDto{
	//후기 조회할떄 board의 title도 뜨게하려고 만든 dto임
	//ReviewDto 상속받아 쓰면 뭔가 좋지 않을까??
	
	private String bWriter;
	private String bApplicants;
	private String category;
	private String title;
	
	
	public BoardReviewDto() {
		super();
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbApplicants() {
		return bApplicants;
	}
	public void setbApplicants(String bApplicants) {
		this.bApplicants = bApplicants;
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
	
	

}
