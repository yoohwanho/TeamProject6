package kr.co.ilque.dto;

public class ReviewDto {
	private int reviewNo;
	private int boardNo;
	private String rWriter;
	private String contents;
	private String date;
	private String imgSrc;
	private int score;
	public ReviewDto() {
		
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getRWriter() {
		return rWriter;
	}
	public void setRWriter(String rWriter) {
		this.rWriter = rWriter;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	

}
