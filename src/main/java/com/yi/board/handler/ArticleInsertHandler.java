package com.yi.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.ArticleService;

public class ArticleInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/articleInsertForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String id = (String) req.getSession().getAttribute("AUTH");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			ArticleService service = ArticleService.getInstance();
			int error = service.insertArticle(id, title, content);
			
			if(error < 0){
				System.out.println("error : " + error);
			}
			
			return "/WEB-INF/view/articleInsertSuccess.jsp";
		}
		return null;
	}

}
