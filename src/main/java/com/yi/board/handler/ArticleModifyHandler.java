package com.yi.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.dao.ArticleDao;
import com.yi.board.model.Article;
import com.yi.board.model.ArticleContent;
import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.ArticleService;

public class ArticleModifyHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			String sNo = req.getParameter("article_no");
			int article_no = Integer.parseInt(sNo);
			ArticleService service = ArticleService.getInstance();
			Article article = service.selectByNo(article_no);
			ArticleContent content = service.selectContentByNo(article_no);

			req.setAttribute("article", article);
			req.setAttribute("content", content);
			return "/WEB-INF/view/articleModifyForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String sNo = req.getParameter("article_no");
			int article_no = Integer.parseInt(sNo);
			String title = req.getParameter("title");
			String content = req.getParameter("content");
		
			ArticleService service = ArticleService.getInstance();
			service.update(article_no, content);
			service.updateModDate(article_no, title);
			
			return "list.do";
		}
		return null;
	}

}
