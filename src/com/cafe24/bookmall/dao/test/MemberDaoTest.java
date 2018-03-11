package com.cafe24.bookmall.dao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cafe24.bookmall.dao.MemberDao;
import com.cafe24.bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		updateTest("플라나리아", "010-1234-5678", "qqq@ddd.com", "12345");
		updateTest("고사리", "010-1234-5678", "ttt@ddd.com", "12345");
		updateTest("말미잘", "010-1234-5678", "ooo@ddd.com", "12345");
		getListTest();
	}
	
	public static void updateTest(String name, String phone, String email, String pw) {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setPassword(pw);
		dao.insertMember(vo);
	}
	
	public static void getListTest() {
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.getListMember();
		
		System.out.println("===============================================");
		System.out.println("회원 목록");
		System.out.println("-----------------------------------------------");
		for (MemberVo vo : list) {
			System.out.println("이름: "+vo.getName()
							+"\n전화번호: "+vo.getPhone()
							+"\n이메일: "+vo.getEmail());
			System.out.println("-----------------------------------------------");
		}
		System.out.println("===============================================");
	}
	
	public static HashMap<Boolean, Long> login(String email, String password) {
		MemberDao dao = new MemberDao();
		return dao.login(email, password);
	}
	
	public static HashMap<Boolean, Long> logout() {
		MemberDao dao = new MemberDao();
		return dao.logout();
	}
}
