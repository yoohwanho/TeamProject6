package kr.co.ilque.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.ilque.dao.OracleMemberDAO;
import kr.co.ilque.dto.MemberDto;

@Service("loginService")
public class LoginService implements QuestService{
	@Resource(name="memberDAO")
	OracleMemberDAO dao;
	
	public void setDao(OracleMemberDAO dao) {
		this.dao = dao;
	}

	//	로그인 체크
	public MemberDto chkLogin(MemberDto dto) {
		return dao.selectOne(dto);
	}
}
  