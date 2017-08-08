package kr.co.ilque.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//	탭으로 언제든지 접근할 수 있는 버튼에 의한 페이지이동.

@Controller
public class mainController {

	//	메인 페이지
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	//	[로그인] 페이지로 넘어감
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	//	로그인 하면 세션에 로그인 정보를 저장하고이전페이지로 넘어감
	//	menu에서 [로그인]버튼과 [회원가입]버튼을 없애고 [로그아웃]버튼과 [마이페이지]버튼이 보이도록 함
	
	//	(로그인 상태일때)로그아웃 버튼을 누르면 세션에서 로그인 정보를 지우고 페이지 유지
	//	menu의 [로그아웃]버튼과 [마이페이지]버튼을 [로그인]버튼과 [회원가입]버튼으로 바꿈
	@RequestMapping("/logout")
	public String logout() {
		return null;
//		return 	"redirect:/(현재페이지)";
	}
	
	//	(로그아웃 상태일때)회원가입 페이지로 넘어감
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return "join";
	}

	//	[해주세요/해드립니다] 누르면 글 작성 페이지로 넘어감
	@RequestMapping("/write")
	public String writeForm() {
		return "writeForm";
	}
	
	//	[거래목록] 버튼을 누르면 최신순으로 거래목록이 뜸
	//	db에서 리스트 가져오기
	@RequestMapping("/board")
	public String showBoard() {
		return "board";
	}
	
	//	[마이페이지]
	//	세션에서 id값을 받아와서 자기 정보 보기
	@RequestMapping("/myPage")
	public String showMyPage() {
		return null;
		//return "userDetail?id="+id;
	}
}
