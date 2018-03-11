package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.CategoryVo;

public class CategoryDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void insertBook(CategoryVo vo) {
		conn = MyConnection.getConnection();
		String sql = "insert into category values(null, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCategoryTitle());

			int count = pstmt.executeUpdate();
			
			// 6. 결과처리
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
	
	public List<CategoryVo> getListCategory() {
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		ResultSet rs = null;
		conn = MyConnection.getConnection();
		String sql = "select no, title from category";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CategoryVo vo = new CategoryVo();
				vo.setCategoryNo(rs.getLong(1));
				vo.setCategoryTitle(rs.getString(2));
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
