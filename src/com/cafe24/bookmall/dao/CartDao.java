package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.CartVo;

public class CartDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void insertCart(CartVo vo) {
		conn = MyConnection.getConnection();
		String sql = "insert into cart values(?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, vo.getMemberNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setInt(3, vo.getAmount());

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
	
	public List<CartVo> getListCart() {
		List<CartVo> list = new ArrayList<CartVo>();
		ResultSet rs = null;
		conn = MyConnection.getConnection();
		String sql = "select b.no, b.name, c.title, c.price, a.amount " + 
				"from cart a, member b, book c " + 
				"where a.member_no = b.no " + 
				"and a.book_no = c.no";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CartVo vo = new CartVo();
				vo.setMemberNo(rs.getLong(1));
				vo.setMemberName(rs.getString(2));
				vo.setBookTitle(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				vo.setAmount(rs.getInt(5));
				list.add(vo);
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
		
		return list;		
	}
}
