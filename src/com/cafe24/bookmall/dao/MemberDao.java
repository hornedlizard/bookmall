package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.MemberVo;

public class MemberDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void insertMember(MemberVo vo) {
		conn = MyConnection.getConnection();
		String sql = "insert into member values(null, ?, ?, ?, password(?))";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPassword());

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
	
	public List<MemberVo> getListMember() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		ResultSet rs = null;
		conn = MyConnection.getConnection();
		String sql = "select no, name, phone, email, password from Member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setMemberNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setPhone(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setPassword(rs.getString(5));
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
