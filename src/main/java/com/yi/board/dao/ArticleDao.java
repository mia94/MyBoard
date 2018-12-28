package com.yi.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.yi.board.model.Article;

public interface ArticleDao {
	public void insert(Article article) throws SQLException;
	public int selectLastNo() throws SQLException;
	public List<Article> select() throws SQLException;
	public Article selectByNo(Article article)throws SQLException;
	public int deleteByNo(Article article) throws SQLException;
	public int updateModDate(Article article) throws SQLException;
	public int updateReadCnt(Article article) throws SQLException;
}
