package com.yi.board.handler;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.ArticleService;

public class ArticleReadJsonHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			//게시물 번호
			String sNo = req.getParameter("no");
			int no = Integer.parseInt(sNo);
			
			ArticleService service = ArticleService.getInstance();
			Map<String, Object> map = service.readArticle(no);
			
			//json자동 만드는 라이브러리 이용
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(map);
			System.out.println(json);
			
			res.setContentType("application/json;charset=utf-8");//json파일 맨위에 정의된 것 여기서 적어줌
			PrintWriter pw = res.getWriter();
			pw.println(json);
			pw.flush();//고객에게 데이타를 보냄
			
		}
		return null;
	}

}
