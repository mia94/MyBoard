package com.yi.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.yi.board.dao.ArticleContentDao;
import com.yi.board.dao.ArticleDao;
import com.yi.board.dao.MemberDao;
import com.yi.board.model.Article;
import com.yi.board.model.ArticleContent;
import com.yi.board.model.Member;
import com.yi.board.mvc.MySqlSessionFactory;

public class ArticleService {
	private static ArticleService service = new ArticleService();
	
	public static ArticleService getInstance(){
		return service;
	}
	// -1 : id에 해당하는 member가 없을 수 있음
	// -2 : article 저장실패
	// -3 : articleContent 저장실패
	// -4 : 특수경우
	//  0 : success
	public int insertArticle(String id, String title, String content){
		
		/*
		 * 1. id에 해당하는 name값 가져오기
		 * 2. article에 저장
		 * 3. article_content 저장  
		 * */
		
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			MemberDao memberDao = session.getMapper(MemberDao.class);
			// 1. id에 해당하는 name값 가져오기
			Member member = memberDao.selectById(id);
			if(member == null){
				return -1;//id에 해당하는 member가 없을 수 있음
			}
			
			// 2. article에 저장
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			Article article = new Article(0, id, member.getName(), title, new Date(), new Date(), 0);
			
			articleDao.insert(article);
			int no = articleDao.selectLastNo();
			if(no<0){
				return -2;
			}
			
			// 3. article_content 저장 
			ArticleContentDao contentDao = session.getMapper(ArticleContentDao.class);
			ArticleContent articleContent = new ArticleContent(no, content);
			contentDao.insert(articleContent);
			
			session.commit();
			return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return -4;//특수경우
	}
	
	public List<Article> articleList(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao dao = session.getMapper(ArticleDao.class);
			return dao.select();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public Map<String, Object> readArticle(int no){//함수이름은 동사가 앞에 명사가 뒤에
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			ArticleContentDao contentDao = session.getMapper(ArticleContentDao.class);
			
			Article arti = new Article();
			arti.setArticle_no(no);
			
			ArticleContent cont = new ArticleContent();
			cont.setArticle_no(no);
			cont = contentDao.selectByNo(cont);
			
			Article article = articleDao.selectByNo(arti);
			
			ArticleContent content = new ArticleContent();
			content.setArticle_no(no);
			content = contentDao.selectByNo(content);
			
			//article, content 두개 다 return 해야함
			Map<String, Object> map = new HashMap<>();
			map.put("article", article);
			map.put("content", content);
			
			session.commit();
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public boolean delete(int article_no){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao dao = session.getMapper(ArticleDao.class);
			
			Article article = new Article();
			article.setArticle_no(article_no);
			article = dao.selectByNo(article);
			
			dao.deleteByNo(article);
			
			ArticleContentDao contentDao = session.getMapper(ArticleContentDao.class);
			
			ArticleContent content = new ArticleContent();
			content.setArticle_no(article_no);
			content = contentDao.selectByNo(content);
			
			contentDao.deleteByNo(content);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}
	
	public boolean update(int article_no, String string){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao dao = session.getMapper(ArticleDao.class);
			ArticleContentDao contentDao = session.getMapper(ArticleContentDao.class);
			
			Article article = new Article();
			article.setArticle_no(article_no);
			article = dao.selectByNo(article);
			
			ArticleContent content = new ArticleContent();
			content.setArticle_no(article_no);
			content = contentDao.selectByNo(content);
			
			
			contentDao.update(content);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
	
	public Article selectByNo(int article_no) throws SQLException{
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao dao = session.getMapper(ArticleDao.class);
			
			Article article = new Article();
			article.setArticle_no(article_no);
			article = dao.selectByNo(article);
			return article;
		} finally {
			session.close();
		}
	}
	
	public ArticleContent selectContentByNo(int article_no) throws SQLException{
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ArticleContentDao dao = session.getMapper(ArticleContentDao.class);

			ArticleContent content = new ArticleContent();
			content.setArticle_no(article_no);
			content = dao.selectByNo(content);
			
			return content;
		} finally {
			session.close();
		}
	}
	
	public boolean updateModDate(int article_no,String string){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao dao = session.getMapper(ArticleDao.class);
			
			Article article = new Article();
			article.setArticle_no(article_no);
			article = dao.selectByNo(article);
			
			dao.updateModDate(article);
			dao.selectByNo(article);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
	
	public boolean updateReadCnt(int article_no, int readCnt){//modify말고 read에서 설정해야함
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao dao = session.getMapper(ArticleDao.class);
			
			Article article = new Article();
			article.setArticle_no(article_no);
			article = dao.selectByNo(article);
			
			dao.updateReadCnt(article);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}
}






















