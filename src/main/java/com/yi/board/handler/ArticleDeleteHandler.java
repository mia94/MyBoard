package com.yi.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.ArticleService;

public class ArticleDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String article_id = req.getParameter("article_no");
		int article_no = Integer.parseInt(article_id);
		
		ArticleService service = ArticleService.getInstance();
		service.delete(article_no);
		
		return "list.do";
	}

}
