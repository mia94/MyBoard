package com.yi.board.model;

import java.util.Date;

public class Member {
	private String memberid;
	private String name;
	private String password;
	private Date regdate;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String memberid, String name, String password, Date regdate) {
		this.memberid = memberid;
		this.name = name;
		this.password = password;
		this.regdate = regdate;
	}

	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return String.format("Member [memberid=%s, name=%s, password=%s, regdate=%s]", memberid, name, password,
				regdate);
	}
	
}
