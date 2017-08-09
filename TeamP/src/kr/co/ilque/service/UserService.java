package kr.co.ilque.service;


import org.springframework.stereotype.Service;

import kr.co.ilque.dao.OracleMemberDAO;
import kr.co.ilque.dto.MemberDto;

@Service(value="UserService")
public class UserService implements QuestService{
	//회원 가입, 수정
	
	OracleMemberDAO dao;
	
	public void insertOne(MemberDto dto) {
		dao.insertOne(dto);
	}
}