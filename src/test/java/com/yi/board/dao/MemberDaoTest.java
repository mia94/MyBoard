package com.yi.board.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yi.board.model.Member;
import com.yi.board.mvc.MySqlSessionFactory;

public class MemberDaoTest {

	@Test
	public void testInsert(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			
			Member member = new Member();
			member.setMemberid("user1");
			member.setName("user1");
			member.setPassword("user1");
			member.setRegdate(new Date());
			
			dao.insert(member);
			
			session.commit();//자동커밋안되니까 꼭 해주기!!
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
