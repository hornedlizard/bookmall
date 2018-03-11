package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.BookVo;

public class BookDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	public void insertBook(BookVo vo) {
		conn = MyConnection.getConnection();
		String sql = "insert into book values(null, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategory());
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
	
	public List<BookVo> getListBook() {
		List<BookVo> list = new ArrayList<BookVo>();
		ResultSet rs = null;
		conn = MyConnection.getConnection();
		String sql = "select a.no, a.title, a.price, b.no, b.title " + 
				"from book a, category b " + 
				"where a.category_no = b.no";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BookVo vo = new BookVo();
				vo.setBookNo(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setCategory(rs.getLong(4));
				vo.setCategoryTitle(rs.getString(5));
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
	
	public BookVo getBookInfo(int bookNo) {
		ResultSet rs = null;
		conn = MyConnection.getConnection();
		BookVo vo = new BookVo();
		String sql = "select a.no, a.title, a.price, b.no, b.title " + 
				"from book a, category b " + 
				"where a.no = ? and a.category_no = b.no";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, bookNo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vo.setBookNo(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setCategory(rs.getLong(4));
				vo.setCategoryTitle(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
}
