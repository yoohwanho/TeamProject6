package kr.co.ilque.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.ilque.dto.MemberDto;

public class OracleMemberDAO {
	SqlSession ss;
	
	public void setSs(SqlSession ss) {
		this.ss = ss;
	}


	public void insertOne(MemberDto dto) {
		ss.insert("kr.co.ilque.member.insertOne",dto);
	}
}
