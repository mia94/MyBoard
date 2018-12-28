package com.yi.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yi.board.mvc.CommandHandler;

public class MemberLogoutHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//세션을 지우면 로그아웃 됨
		
		//getSession(true) : 세션이 이미 있는지 확인하고 있다면 그 세션을 반환, 없다면 새로운 세션을 생성
		//getSession(false) : 세션이 있다면 그 세션을 리턴, 세션이 존재하지 않는다면 null을 리턴
		HttpSession session = req.getSession(false);
		if(session != null){
			session.invalidate();//세션삭제
		}
		//리다이렉트가 필요할때 사용하는 방법 두줄
		res.sendRedirect("index.jsp");		
		return null;//"index.jsp"로 보내기위해서 forward를 피해가야함
	}

}
