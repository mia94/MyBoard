package com.yi.board.service;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yi.board.dao.MemberDao;
import com.yi.board.model.Member;
import com.yi.board.mvc.MySqlSessionFactory;

public class MemberService {
	private static MemberService service = new MemberService();
	
	public static MemberService getInstance(){
		return service;
	}
	
	public int insertMember(Member mem){
		SqlSession session = null;
		
		// 0 : 정상적인 insert처리가 될때
		//-1 : insert가 안되었을때(임의로 지정한 것)
		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			dao.insert(mem);
			session.commit();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return -1;
	}
	
	//true : 중복된 멤버가 있습니다.
	//false : 중복된 멤버가 없습니다.
	public boolean duplicatedMember(String id){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			Member mem = dao.selectById(id);
			if(mem != null){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return false;
	}
	
	public List<Member> selectByAll(){
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			List<Member> list = dao.selectByAll();
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return null;
	}
	
	//  0: id와 password가 일치
	// -1: pw가 일치하지 않음
	// -2: id가 없음(회원가입 안됨)
	// -3: error
	public int checkLoginMember(String id, String password){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			Member member = dao.selectById(id);
			if(member == null){
				return -2;
			}
			if(member.getPassword().equals(password)==false){
				return -1;
			}
			
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return -3;
	}
	
	//비밀번호 변경 인증용
	public int checkPassword(String id, String newPassword){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			Member member = dao.selectById(id);
			int res = dao.updateById(member);
			return res;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return 0;
	}

	
}


















