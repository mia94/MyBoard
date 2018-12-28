package com.yi.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.yi.board.model.Member;

public interface MemberDao {
	
	public void insert(Member member) throws SQLException;
	public Member selectById(String memberid) throws SQLException;
	public List<Member> selectByAll() throws SQLException;
	public int updateById(Member member) throws SQLException;
}
