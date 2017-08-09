package kr.co.ilque.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.dto.MemberDto;
import kr.co.ilque.service.UserService;

//	회원가입 화면에서의 화면이동
@Controller
public class JoinController {
	@Resource(name="userService")
	UserService us;

	public void setUs(UserService us) {
		this.us = us;
	}




	//	회원가입버튼을 누르면 memberDTO와 isJoin=1을 가지고 로그인페이지로
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String joinOk(
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPwd") String memberPwd,
			@RequestParam("memberName")	String memberName,			
			@RequestParam("filePath") String profileSrc,		
			@RequestParam("phone")	String phone,
			@RequestParam("gender") String gender,
			@RequestParam("birth") String birth,
			@RequestParam("contents") String contents,
			HttpServletRequest req
			) {
		MemberDto dto = new MemberDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		dto.setMemberName(memberName);
		dto.setProfileSrc(profileSrc);
		dto.setGender(gender);
		dto.setPhone(phone);
		dto.setContents(contents);
		System.out.println(profileSrc);
		//contents?
		dto.setBirth(birth);
		us.insertOne(dto);
		
		req.setAttribute("isJoin", true);
		return "login";
	}

}
