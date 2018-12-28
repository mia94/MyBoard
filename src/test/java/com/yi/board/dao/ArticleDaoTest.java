package com.yi.board.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yi.board.model.Article;
import com.yi.board.mvc.MySqlSessionFactory;

public class ArticleDaoTest {

	@Test
	public void insert(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao dao = session.getMapper(ArticleDao.class);
			
			Article article = new Article();
			article.setWriter_id("mimimi");
			article.setWriter_name("미미미");
			article.setTitle("신규입당");
			article.setRead_cnt(0);
			article.setModdate(new Date());
			article.setRegdate(new Date());
			dao.insert(article);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void select(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao dao = session.getMapper(ArticleDao.class);
			
			List<Article> list = new ArrayList<>();
			list = dao.select();

			System.out.println(list);

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}

















