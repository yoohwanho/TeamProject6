package kr.co.ilque.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.dto.MemberDto;
import kr.co.ilque.service.KeywordsService;

//	탭으로 언제든지 접근할 수 있는 버튼에 의한 페이지이동.

@Controller
public class mainController {
	
	@Resource(name = "keywordsService")
	KeywordsService ks;

	//	메인 페이지
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list",ks.select10());
		mav.setViewName("main");
		return mav;
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
//		return 	"redirect:/(현재페이지)";
	
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
	
	//	[마이페이지]
	//	세션에서 id값을 받아와서 자기 정보 보기
	@RequestMapping("/myPage")
	public String showMyPage( HttpSession ss) {
		MemberDto mdto =(MemberDto)ss.getAttribute("mdto");
		return "userDetail?id="+mdto.getMemberId();
	}
}
