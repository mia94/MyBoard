package com.yi.board.model;

public class ArticleContent {
	private int article_no;
	private String content;
	
	public ArticleContent() {

	}

	public ArticleContent(int article_no, String content) {
		super();
		this.article_no = article_no;
		this.content = content;
	}

	public int getArticle_no() {
		return article_no;
	}

	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
