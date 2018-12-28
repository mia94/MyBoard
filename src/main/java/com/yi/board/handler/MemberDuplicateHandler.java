package com.yi.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.MemberService;

public class MemberDuplicateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ajax를 이용
		if(req.getMethod().equalsIgnoreCase("get")){
			String id = req.getParameter("id");
			
			MemberService service = MemberService.getInstance();
			boolean result = service.duplicatedMember(id);
			req.setAttribute("result", result);
			return "/WEB-INF/view/duplicatedID.jsp";//화면에 보여지는 용의 파일X
		}
		return null;
	}

}
