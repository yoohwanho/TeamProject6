package kr.co.ilque.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ilque.dto.MemberDto;

public class OracleMemberDAO {
	SqlSession ss;
	
	//	로그인시 아이디와 pw가 db에 있는지 확인
	public MemberDto selectOne(MemberDto dto){
		return ss.selectOne("kr.co.ilque.member.login",dto);		
	}
	
	//	가입
	
	//	정보수정
	
}
