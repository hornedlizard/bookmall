package com.cafe24.bookmall.vo;

public class MemberVo {

	private long memberNo;
	private String name;
	private String phone;
	private String email;
	private String password;
	
	public long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(long memberNo) {
		this.memberNo = memberNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "MemberVo [memberNo=" + memberNo + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}