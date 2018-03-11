package com.cafe24.bookmall.vo;

public class OrderVo {

	private long orderNo;
	private String orderNumber;
	private int amountPayment;
	private String address;
	private String orderDate;
	private MemberVo memberVo;
	
	public long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getAmountPayment() {
		return amountPayment;
	}
	public void setAmountPayment(int amountPayment) {
		this.amountPayment = amountPayment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public MemberVo getMemberVo() {
		return memberVo;
	}
	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}
	
	@Override
	public String toString() {
		return "OrderVo [orderNo=" + orderNo + ", orderNumber=" + orderNumber + ", amountPayment=" + amountPayment
				+ ", address=" + address + ", orderDate=" + orderDate + ", memberVo=" + memberVo + "]";
	}
			
}
