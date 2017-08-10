package kr.co.ilque.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.dto.MemberDto;
import kr.co.ilque.service.LoginService;
import kr.co.ilque.service.UserService;

//마이페이지에서의 페이지 이동

@Controller
public class MemberController {
	@Resource(name = "userService")
	UserService us;
	
	@Resource(name="loginService")
	LoginService ls;

	public void setUs(UserService us) {
		this.us = us;
	}
	
	

	public void setLs(LoginService ls) {
		this.ls = ls;
	}



	// [수정]버튼 누르면 정보 수정하기
	// id값으로 기존 정보를 불러와서 미리 채워놓고 수정한 값을 db에 update한다
	// 작성 후엔 마이페이지로 다시 이동.@RequestMapping("/modify")
	@RequestMapping(value="/modifyForm", method=RequestMethod.POST)
	public ModelAndView goModifyForm(
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPwd") String memberPwd,
			@RequestParam("memberName") String memberName,
			@RequestParam("profileSrc") String profileSrc,
			@RequestParam("phone") String phone,
			@RequestParam("contents") String contents,
			@RequestParam("gender") String gender			
			) {
		
		MemberDto dto = new MemberDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		dto.setMemberName(memberName);
		dto.setProfileSrc(profileSrc);
		dto.setGender(gender);
		dto.setPhone(phone);
		dto.setContents(contents);
		ls.pickMemberInfo(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("mdto", dto);
		mav.setViewName("userModify");
		
		
		return mav;
	}

	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ModelAndView modify(@RequestParam("memberId") String memberId, @RequestParam("memberPwd") String memberPwd,
			@RequestParam("memberName") String memberName, @RequestParam("phone") String phone,
			@RequestParam("gender") String gender, @RequestParam("filePath") String profileSrc,
			@RequestParam("contents") String contents) {

		MemberDto dto = new MemberDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		dto.setMemberName(memberName);
		dto.setProfileSrc(profileSrc);
		dto.setGender(gender);
		dto.setPhone(phone);
		dto.setContents(contents);
		us.updateOne(dto);
		ls.pickMemberInfo(dto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("mdto",dto);
		mav.setViewName("userDetail");

		return mav;

	}

}
