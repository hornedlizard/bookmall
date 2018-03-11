package com.cafe24.bookmall.app;

import java.util.HashMap;
import java.util.List;

import com.cafe24.bookmall.dao.MemberDao;
import com.cafe24.bookmall.dao.test.BookDaoTest;
import com.cafe24.bookmall.dao.test.CartDaoTest;
import com.cafe24.bookmall.dao.test.CategoryDaoTest;
import com.cafe24.bookmall.dao.test.MemberDaoTest;
import com.cafe24.bookmall.dao.test.OrderDaoTest;
import com.cafe24.bookmall.vo.MemberVo;
import com.cafe24.bookmall.vo.OrderVo;

public class BookMallApp {

	public static void main(String[] args) {
		updateAll();
		System.out.println("================================");
		getAllList();
	}
	
	public static void updateAll() {
		// 데이터 입력
		MemberDaoTest.updateTest("고사리", "010-1234-5678", "gogo@ddd.com", "12345");
		MemberDaoTest.updateTest("스누피", "010-9876-5432", "ppp@ppp.com", "09876");
		System.out.println("회원 정보 입력 완료");
		
		CategoryDaoTest.updateTest("컴퓨터");
		CategoryDaoTest.updateTest("인문");
		CategoryDaoTest.updateTest("소설");
		System.out.println("카테고리 입력 완료");
		
		BookDaoTest.updateTest("달려라 아비", 10000, 3);
		BookDaoTest.updateTest("피로사회", 9000, 2);
		BookDaoTest.updateTest("토비토비", 30000, 1);
		System.out.println("도서 정보 입력 완료");
		
		// 회원 번호, 도서 번호, 수량
		CartDaoTest.updateTest(1, 2, 3);
		CartDaoTest.updateTest(2, 3, 1);
		System.out.println("카트 담기 완료");
		
		System.out.println("------------------------------------");
		// 주문 도서와 수량 선택 <도서 번호, 주문 수량>
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(2, 1);
		map.put(3, 3);
		
		// 주문 도서 선택
		OrderVo vo = new OrderVo();
		MemberVo member = new MemberVo();
		member.setMemberNo(1); // 주문자 회원 번호
		vo.setAddress("뻐꾸기둥지"); // 배송지
		vo.setMemberVo(member); // 주문에 주문자 입력
		
		// 도서 주문
		OrderDaoTest.updateTest(vo, map);
		System.out.println("주문 테이블 완료");
		OrderDaoTest.updateBookOrderTest(map);
		System.out.println("주문 도서 목록1 저장 완료");
		
		System.out.println("------------------------------------");
		// 주문 도서와 수량 선택 <도서 번호, 주문 수량>
		HashMap<Integer, Integer> map2 = new HashMap<>();
		map2.put(3, 2);
		map2.put(2, 2);

		OrderVo vo2 = new OrderVo();
		MemberVo member2 = new MemberVo();
		member2.setMemberNo(2); // 주문자 회원 번호
		vo2.setAddress("비트캠프"); // 배송지
		vo2.setMemberVo(member2); // 주문에 주문자 입력

		OrderDaoTest.updateTest(vo2, map2);
		System.out.println("주문 테이블 완료");
		OrderDaoTest.updateBookOrderTest(map2);
		System.out.println("주문 도서 목록2 저장 완료");
		System.out.println("------------------------------------");
	}
	
	public static void getAllList() {
		MemberDaoTest.getListTest();
		CategoryDaoTest.getListTest();
		BookDaoTest.getListTest();
		CartDaoTest.getListTest();
		MemberDao mDao  = new MemberDao();
		List<MemberVo> mList = mDao.getListMember();
		for (MemberVo vo : mList) {
			OrderDaoTest.getListTest(vo.getMemberNo());			
		}
	}
	
}
