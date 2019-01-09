package com.yi.board.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.yi.board.model.Article;
import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.ArticleService;

public class ArticleListJsonHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")){
			ArticleService service = ArticleService.getInstance();
			List<Article> list = service.articleList();
			
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(list);
			
			res.setContentType("application/json;charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.print(json);
			pw.flush();
		}
		return null;
	}

}
