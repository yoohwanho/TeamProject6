package kr.co.ilque.service;

import kr.co.ilque.dao.OracleMemberDAO;
import kr.co.ilque.dto.MemberDto;

public class LoginService implements Service{
	OracleMemberDAO dao;
	
	//	로그인 체크
	public MemberDto chkLogin(MemberDto dto) {
		return dao.selectOne(dto);
	}
}
  