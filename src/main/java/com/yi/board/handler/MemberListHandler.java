package com.yi.board.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.model.Member;
import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.MemberService;

public class MemberListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			MemberService service = MemberService.getInstance();
			List<Member> list = service.selectByAll();
			req.setAttribute("result", list);
			return "/WEB-INF/view/memberlist.jsp";
		}
		return null;
	}

}
