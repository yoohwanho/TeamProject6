package kr.co.ilque.service;

import javax.annotation.Resource;

import kr.co.ilque.dao.OracleMemberDAO;
import kr.co.ilque.dto.MemberDto;

@org.springframework.stereotype.Service("loginService")
public class LoginService implements QuestService{
	@Resource(name="MemberDAO")
	OracleMemberDAO dao;
	
	public void setDao(OracleMemberDAO dao) {
		this.dao = dao;
	}

	//	로그인 체크
	public MemberDto chkLogin(MemberDto dto) {
		return dao.selectOne(dto);
	}
}
  