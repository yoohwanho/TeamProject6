package kr.co.ilque.dto;

public class ListViewDTO {
//select rn, boardno, category, title, writer,hits, regdate, reward, time, commentCounts
	int rn;
	int boardno;
	String category;
	String title;
	String writer;
	String hits;
	String regdate;
	String reward;
	String time;
	int commentCounts;
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getHits() {
		return hits;
	}
	public void setHits(String hits) {
		this.hits = hits;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCommentCounts() {
		return commentCounts;
	}
	public void setCommentCounts(int commentCounts) {
		this.commentCounts = commentCounts;
	}
		
}
