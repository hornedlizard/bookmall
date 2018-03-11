package com.cafe24.bookmall.vo;

public class OrderBookVo {

	private long orderBookNo;
	private long bookNo;
	private String title;
	private int price;
	private int amount;
	private long orderNo;
	
	public long getOrderBookNo() {
		return orderBookNo;
	}
	public void setOrderBookNo(long orderBookNo) {
		this.orderBookNo = orderBookNo;
	}
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}
	
	@Override
	public String toString() {
		return "OrderBookVo [orderBookNo=" + orderBookNo + ", bookNo=" + bookNo + ", title=" + title + ", price="
				+ price + ", amount=" + amount + ", orderNo=" + orderNo + "]";
	}
		
}
