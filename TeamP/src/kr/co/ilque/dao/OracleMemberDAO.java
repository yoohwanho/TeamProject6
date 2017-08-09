package kr.co.ilque.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ilque.dto.MemberDto;

public class OracleMemberDAO {
	SqlSession ss;
	
	public List<MemberDto> selectAll(){
		
		return ss.selectList("kr.)
		
	}
	
}
