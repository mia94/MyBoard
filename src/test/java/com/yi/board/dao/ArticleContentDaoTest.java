package com.yi.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yi.board.model.ArticleContent;
import com.yi.board.mvc.MySqlSessionFactory;

public class ArticleContentDaoTest {
	
	@Test
	public void insert(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ArticleContentDao dao = session.getMapper(ArticleContentDao.class);
			
			ArticleContent content = new ArticleContent();
			content.setArticle_no(9);
			content.setContent("할루할루");
			dao.insert(content);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
