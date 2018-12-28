package com.yi.board.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.model.Member;
import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.MemberService;

public class MemberJoinHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/joinForm.jsp";//WebContent를 기준으로 경로를 맞춤
		}else if(req.getMethod().equalsIgnoreCase("post")){
//			req.setCharacterEncoding("utf-8"); 자동으로 되게 하기
			
			String memberid = req.getParameter("memberid");
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			
			Member member = new Member(memberid, name, password, new Date());//시간은 자동으로 기입
			
			MemberService service = MemberService.getInstance();
			service.insertMember(member);
			
			req.setAttribute("name", name);
			res.sendRedirect("login.do");
			return null;//"/WEB-INF/view/joinResult.jsp"로 리턴하면 join.do주소가 새로고침될때 insert가 이루어져서 기본키중복에서 발생
		}
		return null;
	}

}
