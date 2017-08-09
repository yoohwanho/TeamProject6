package kr.co.ilque.service;


import kr.co.ilque.dao.OracleMemberDAO;
import kr.co.ilque.dto.MemberDto;

public class UserService implements QuestService{
	//회원 가입, 수정
	
	OracleMemberDAO dao;
	
	public void insertOne(MemberDto dto) {
		dao.insertOne(dto);
	}
}