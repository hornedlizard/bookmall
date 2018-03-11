package com.cafe24.bookmall.dao.test;

import java.util.HashMap;
import java.util.List;

import com.cafe24.bookmall.dao.OrderDao;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.MemberVo;
import com.cafe24.bookmall.vo.OrderBookVo;
import com.cafe24.bookmall.vo.OrderVo;


public class OrderDaoTest {

	public static void main(String[] args) {
		/*HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(2, 1);
		map.put(3, 3);
		
		OrderVo vo = new OrderVo();
		MemberVo member = new MemberVo();
		member.setMemberNo(2);
		vo.setAddress("뻐꾸기둥지");
		vo.setMemberVo(member);
		updateTest(vo, map);
		
		updateBookOrderTest(map);*/
		
		getListTest(1);
		getListTest(2);
	}
	
	public static void updateTest(OrderVo vo, HashMap<Integer, Integer> map) {
		OrderDao dao = new OrderDao();
		dao.insertOrder(vo, map);
	}
	
	public static void updateBookOrderTest(HashMap<Integer, Integer> map) {
		OrderDao dao = new OrderDao();
		dao.insertOrderBook(map);
	}
	
	public static void getListTest(long memberNo) {
		OrderDao dao = new OrderDao();
//		List<OrderVo> list = dao.getListOrder(2);
		HashMap<OrderVo, List<OrderBookVo>> list = dao.getListOrder(memberNo);
		
		for (OrderVo vo : list.keySet()) {
			System.out.println("===============================================");
			System.out.println("주문 내용");
			System.out.println("-----------------------------------------------");
			System.out.println("주문번호: "+vo.getOrderNumber()
							+"\n주문자: "+vo.getMemberVo().getName()
							+"\n주문날짜: "+vo.getOrderDate()
							+"\n가격: "+vo.getAmountPayment()
							+"\n배송지: "+vo.getAddress());
			System.out.println("***********************************************");
			System.out.println("주문 도서 목록");
			System.out.println("-----------------------------------------------");
			for (int i = 0; i < list.get(vo).size(); i++) {
				System.out.println("제목: "+list.get(vo).get(i).getTitle()
						+" | 가격: "+list.get(vo).get(i).getPrice()
						+" | 수량: "+list.get(vo).get(i).getAmount());				
			}
		}
		System.out.println("===============================================");
	}
}
