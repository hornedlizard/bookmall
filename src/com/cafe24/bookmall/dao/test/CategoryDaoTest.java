package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		updateTest("소설");
		getListTest();
	}
	
	public static void updateTest(String title) {
		CategoryDao dao = new CategoryDao();
		CategoryVo vo = new CategoryVo();
		vo.setCategoryTitle(title);
		dao.insertBook(vo);
	}
	
	public static void getListTest() {
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getListCategory();
		
		System.out.println("===============================================");
		System.out.println("카테고리");
		System.out.println("-----------------------------------------------");
		for (CategoryVo vo : list) {
			System.out.println(vo.getCategoryNo()+": "+vo.getCategoryTitle());
		}
		System.out.println("-----------------------------------------------");
		System.out.println("===============================================");
	}
}
