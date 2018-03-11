package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.CartDao;
import com.cafe24.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		updateTest(1, 1, 1);
		getListTest();
	}
	
	public static void updateTest(long memberNo, long bookNo, int amount) {
		CartDao dao = new CartDao();
		CartVo vo = new CartVo();
		vo.setMemberNo(memberNo);
		vo.setBookNo(bookNo);
		vo.setAmount(amount);
		dao.insertCart(vo);
	}
	
	public static void getListTest() {
		CartDao dao = new CartDao();
		List<CartVo> list = dao.getListCart();
		
		System.out.println("===============================================");
		System.out.println("카트 내용");
		System.out.println("-----------------------------------------------");
		for (CartVo vo : list) {
			System.out.println("****"+vo.getMemberName()+"님의 카트****"
							+"\n제목: "+vo.getBookTitle()
							+"\n가격: "+vo.getPrice()
							+"\n수량: "+vo.getAmount());
			System.out.println("-----------------------------------------------");
		}
		System.out.println("===============================================");
	}
}
