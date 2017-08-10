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
	public MemberDto chkLogin(MemberDto mdto) {
		return dao.selectOne(mdto);
	}
	
	public MemberDto pickMemberInfo(MemberDto mdto) {
		System.out.println("로그인서비스에서실행된:"+ mdto.getMemberId());
		System.out.println(mdto);
		System.out.println(dao);
		System.out.println(dao.showMember(mdto));
		
		
		return dao.showMember(mdto);
	}
}
  