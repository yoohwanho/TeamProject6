package kr.co.ilque.dao;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ilque.dto.MemberDto;

@Repository("memberDAO")
public class OracleMemberDAO {
	@Autowired
	SqlSession ss;
	
	public void setSs(SqlSession ss) {
		this.ss = ss;
	}
	
	//	로그인시 아이디와 pw가 db에 있는지 확인
	public MemberDto selectOne(MemberDto dto){
		return ss.selectOne("kr.co.ilque.member.login",dto);		
	}
	
	//	가입
	public void insertOne(MemberDto dto) {
		ss.insert("kr.co.ilque.member.insertOne",dto);
	}
	
	//	정보수정
	
}
