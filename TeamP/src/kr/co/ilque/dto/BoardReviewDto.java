package kr.co.ilque.dto;

public class BoardReviewDto extends ReviewDto{
	
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
