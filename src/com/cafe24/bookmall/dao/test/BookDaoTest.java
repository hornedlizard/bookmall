package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		updateTest("달려라 아비", 10000, 1);
//		updateTest("토비토비", 30000, 3);
//		updateTest("피로사회", 9000, 2);
		getListTest();
	}
	
	public static void updateTest(String title, int price, long category) {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategory(category);
		dao.insertBook(vo);
	}
	
	public static void getListTest() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getListBook();
		
		System.out.println("===============================================");
		System.out.println("도서 목록");
		System.out.println("-----------------------------------------------");
		for (BookVo vo : list) {
			System.out.println("제목: "+vo.getTitle()
							+"\n가격: "+vo.getPrice()
							+"원\n분야: "+vo.getCategoryTitle());
			System.out.println("-----------------------------------------------");
		}
		System.out.println("===============================================");
	}
}
