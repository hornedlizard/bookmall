package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.cafe24.bookmall.vo.MemberVo;
import com.cafe24.bookmall.vo.OrderBookVo;
import com.cafe24.bookmall.vo.OrderVo;

public class OrderDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void insertOrder(OrderVo vo, HashMap<Integer, Integer> map) {
		conn = MyConnection.getConnection();
		BookDao bookDao = new BookDao();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
		String orderNumber = sdf.format(date)+"@"+Long.toString(vo.getMemberVo().getMemberNo());
		
		String sql = "insert into ordering values(null, ?, ?, ?, now(), ?)";
		int amountPayment = 0;
		for (int bookNo : map.keySet()) {
			amountPayment += bookDao.getBookInfo(bookNo).getPrice() * map.get(bookNo);
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderNumber);
			pstmt.setInt(2, amountPayment);
			pstmt.setString(3, vo.getAddress());
			pstmt.setLong(4, vo.getMemberVo().getMemberNo());
			
			int count = pstmt.executeUpdate();
			
			if (count == 0) {
				System.out.println("실패");
			} else {
				System.out.println("성공");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("에러"+e);
			}
		}
	}
	
	public void insertOrderBook(HashMap<Integer, Integer> map) {
		conn = MyConnection.getConnection();
		BookDao bookDao = new BookDao();
		
		String sql = "insert into "
				+ "order_book(book_no, price, amount, order_no) "
				+ "values (?, ?, ?,"
				+ " (select last_insert_id(no) from ordering order by no desc limit 0, 1))";
		try {
			pstmt = conn.prepareStatement(sql);
			for (int bookNo : map.keySet()) {
				pstmt.setLong(1, bookNo);
				pstmt.setInt(2, bookDao.getBookInfo(bookNo).getPrice());
				pstmt.setInt(3, map.get(bookNo));
				
				int count = pstmt.executeUpdate();
				
				if (count == 0) {
					System.out.println("실패");
				} else {
					System.out.println("성공");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public HashMap<OrderVo, List<OrderBookVo>> getListOrder(long memberNo) {
		HashMap<OrderVo, List<OrderBookVo>> orderList = new HashMap<OrderVo, List<OrderBookVo>>();
		List<OrderBookVo> orderBookList = new ArrayList<OrderBookVo>();
		conn = MyConnection.getConnection();
		ResultSet rs = null;
		String sql = 
				"select a.no, a.order_number, a.amount_payment, a.address, order_date, b.name " + 
				"from ordering a, member b " + 
				"where a.member_no = b.no " + 
				"and b.no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, memberNo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				OrderVo vo = new OrderVo();
				MemberVo member = new MemberVo();
				long orderNo = rs.getLong(1);
				vo.setOrderNo(orderNo);
				vo.setOrderNumber(rs.getString(2));
				vo.setAmountPayment(rs.getInt(3));
				vo.setAddress(rs.getString(4));
				vo.setOrderDate(rs.getString(5));
				member.setName(rs.getString(6));
				vo.setMemberVo(member);
//				list.add(vo);
				orderBookList = getOrderBookList(orderNo);
				orderList.put(vo, orderBookList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();					
				}
			} catch (SQLException e) {
				System.out.println("에러"+e);
			}
		}
		
		return orderList;		
	}
	
	public List<OrderBookVo> getOrderBookList(long orderNo) {
		//conn = MyConnection.getConnection();
		ResultSet rs = null;
		List<OrderBookVo> list = new ArrayList<>();
		String sql = "select a.title, a.price, b.amount " + 
				"from book a, order_book b " + 
				"where b.order_no = ? " + 
				"and a.no = b.book_no";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, orderNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderBookVo vo = new OrderBookVo();
				vo.setTitle(rs.getString(1));
				vo.setPrice(rs.getInt(2));
				vo.setAmount(rs.getInt(3));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
