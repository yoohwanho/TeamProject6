package kr.co.ilque.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.dto.MemberDto;
import kr.co.ilque.service.KeywordsService;
import kr.co.ilque.service.LoginService;

//	탭으로 언제든지 접근할 수 있는 버튼에 의한 페이지이동.

@Controller
public class mainController {
	
	@Resource(name = "keywordsService")
	KeywordsService ks;
	@Resource(name="loginService")
	LoginService ls;
	boolean isLogin;
	
	

	public void setLs(LoginService ls) {
		this.ls = ls;
	}

	
	//	메인 페이지
	@RequestMapping("/main")
	public ModelAndView main(HttpSession ss) {
		if(ss.getAttribute("isLogin")==null) {
			//	isLogin이 null일 경우 사이트에 첫 접근으로 판단하여 isLogin을 false로
			isLogin=false;
			//	세션에 저장한다
			ss.setAttribute("isLogin", isLogin);
		}
		return new ModelAndView("main","list",ks.select10());
	}
	
	//	[로그인] 페이지로 넘어감
	@RequestMapping("/login")
	public String login(HttpSession ss) {
		boolean isLogin = (boolean)ss.getAttribute("isLogin");
		
		if(!isLogin) {
			return "login";
		}else{
			//	로그인 상태에서 접근할 경우 메인페이지로 이동
			return "redirect:/main";
		}
	}
	
	//	로그인 하면 세션에 로그인 정보를 저장하고이전페이지로 넘어감
	//	menu에서 [로그인]버튼과 [회원가입]버튼을 없애고 [로그아웃]버튼과 [마이페이지]버튼이 보이도록 함
	
	//	(로그인 상태일때)로그아웃 버튼을 누르면 세션에서 로그인 정보를 지우고 페이지 유지
	//	menu의 [로그아웃]버튼과 [마이페이지]버튼을 [로그인]버튼과 [회원가입]버튼으로 바꿈
//		return 	"redirect:/(현재페이지)";
	
	//	(로그아웃 상태일때)회원가입 페이지로 넘어감
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(HttpSession ss) {
		boolean isLogin = (boolean)ss.getAttribute("isLogin");
		
		if(!isLogin) {
			return "join";			
		}else {
			//	로그인 상태에서 접근할 경우 메인페이지로 이동
			return "redirect:/main";
		}
	}

	//	[해주세요/해드립니다] 누르면 글 작성 페이지로 넘어감
	@RequestMapping("/write")
	public ModelAndView writeForm(HttpSession ss) {
		boolean isLogin = (boolean)ss.getAttribute("isLogin");
		
		if(!isLogin) {
			//로그아웃상태일 경우 로그인화면으로 이동
			return new ModelAndView("redirect:/login","isAccess",true);
		}else{
			return new ModelAndView("writeForm");
		}
	}
	
	//	[마이페이지]
	@RequestMapping("/myPage")
	public ModelAndView showMyPage( HttpSession ss) {
		boolean isLogin = (boolean)ss.getAttribute("isLogin");
		
		if(!isLogin) {
			//로그아웃상태일 경우 로그인화면으로 이동
			return new ModelAndView("login","isAccess",true);
		}else{
			//	로그인 상태일 경우 이동
			//	멤버객체 생성
			MemberDto mdto = new MemberDto();
			
			//	session에 저장된 id를 멤버객체에 set
			if(ss.getAttribute("id")!=null) {
				mdto.setMemberId((String)ss.getAttribute("id"));			
			}
			System.out.println(mdto.getMemberId());
			//	id가 저장된 멤버객체로 관련 정보 담아오기
			//	LoginService ls = new LoginService();
			mdto=ls.pickMemberInfo(mdto);
			
			return new ModelAndView("userDetail","mdto",mdto);
		}
	}
}
