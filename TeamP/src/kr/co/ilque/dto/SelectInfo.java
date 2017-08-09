package kr.co.ilque.dto;

public class SelectInfo {
	//성별, 카테고리, 검색어, 최대금액 최소금액, 페이지번호 있어야
	//mapper xml에 변수넘기기가 편해진다.
		
		private int startNo;
		private int endNo;
		private String keyword;
		private String category;
		private String gender;
		private Integer min;
		private Integer max;
		public SelectInfo() {
			super();
		}
		public String getOrderBy() {
			return orderBy;
		}
		public void setOrderBy(String orderBy) {
			this.orderBy = orderBy;
		}
		private String orderBy;
		
		public int getStartNo() {
			return startNo;
		}
		public void setStartNo(int startNo) {
			this.startNo = startNo;
		}
		public int getEndNo() {
			return endNo;
		}
		public void setEndNo(int endNo) {
			this.endNo = endNo;
		}
		public String getKeyword() {
			return keyword;
		}
		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
		public int getMax() {
			return max;
		}
		public void setMax(int max) {
			this.max = max;
		}
		
		
		
}
