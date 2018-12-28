package com.yi.board.dao;

import java.sql.SQLException;

import com.yi.board.model.ArticleContent;

public interface ArticleContentDao {
	
	public void insert(ArticleContent content) throws SQLException;
	public ArticleContent selectByNo(ArticleContent content) throws SQLException;
	public int deleteByNo(ArticleContent content)throws SQLException;
	public int update(ArticleContent content) throws SQLException;
}
