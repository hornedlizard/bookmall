package com.cafe24.bookmall.vo;

public class CategoryVo {

	private long categoryNo;
	private String categoryTitle;
	
	public long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	
	@Override
	public String toString() {
		return "CategoryVo [categoryNo=" + categoryNo + ", categoryTitle=" + categoryTitle + "]";
	}
	
}
