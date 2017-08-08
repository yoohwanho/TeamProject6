package kr.co.ilque.dto;

public class KeywordsDto {
	private int keywordNo;
	private String kword;
	private int counts;
	
	public KeywordsDto() {
		super();
	}
	public int getKeywordNo() {
		return keywordNo;
	}
	public void setKeywordNo(int keywordNo) {
		this.keywordNo = keywordNo;
	}
	public String getKword() {
		return kword;
	}
	public void setKword(String kword) {
		this.kword = kword;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}

	
}
