package com.yi.board.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yi.board.dao.MemberDao;
import com.yi.board.model.Member;
import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.MemberService;

public class MemberChangePwdHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/changePwdForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String oldPassword = req.getParameter("oldPassword");//원래암호
			String newPassword = req.getParameter("newPassword");//새암호
			HttpSession session = req.getSession(false);//세션에 저장된 아이디 가져오기
			String id = (String) session.getAttribute("AUTH");//아이디, 오브젝트를 반환하기때문에 캐스팅필요
			
			MemberService service = MemberService.getInstance();
			
			//현재암호와 입력된 암호 비교하기
			int same = service.checkLoginMember(id, oldPassword);
			if(same==0){
				int success = service.checkPassword(id, newPassword);
//				System.out.println("success-"+success); success가 반환하는 값 확인
				if(success==1){
					//비밀번호 변경성공
					return "/WEB-INF/view/changePwdSuccess.jsp";
				}
			}else if(same!=0){
				//현재비밀번호 불일치
				req.setAttribute("error", "현재암호가 일치하지 않습니다.");
				return "/WEB-INF/view/changePwdForm.jsp";
			}
			
		}
		return null;
	}

}
