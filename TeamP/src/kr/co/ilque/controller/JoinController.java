package kr.co.ilque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//	회원가입 화면에서의 화면이동
@Controller
public class JoinController {
	
	//	회원가입버튼을 누르면 memberDTO와 isJoin=1을 가지고 로그인페이지로
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String joinOk() {
		return "login";
	}

}
