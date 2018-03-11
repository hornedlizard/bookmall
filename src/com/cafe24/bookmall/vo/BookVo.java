package com.cafe24.bookmall.vo;

public class BookVo {
	private long bookNo;
	private String title;
	private int price;
	private long category;
	private String categoryTitle;
	
	public long getBookNo() {
		return bookNo;
	}
	public void setBookNo(long bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	
	@Override
	public String toString() {
		return "BookVo [bookNo=" + bookNo + ", title=" + title + ", price=" + price + ", category=" + category
				+ ", categoryTitle=" + categoryTitle + "]";
	}
	
}
