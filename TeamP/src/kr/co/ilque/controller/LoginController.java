package kr.co.ilque.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.dto.MemberDto;
import kr.co.ilque.service.LoginService;
import kr.co.ilque.service.QuestService;

@Controller
public class LoginController {
	@Resource(name="loginService")
	LoginService sv;
	boolean isLogin = false;

	@RequestMapping(value = "/tryLogin", method = RequestMethod.POST)
	public ModelAndView tryLogin(@RequestParam("id") String memberId, @RequestParam("pw") String memberPwd,
			HttpServletRequest req, HttpSession ss) {

		System.out.println("id,pw = " + memberId + "," + memberPwd);
		System.out.println("url:" + req.getParameter("url"));

		// 로그인
		// 로그인 성공: 세션에 로그인 정보.
		MemberDto mdto = new MemberDto();
		mdto.setMemberId(memberId);
		mdto.setMemberPwd(memberPwd);
		if ( sv.chkLogin(mdto)!=null) {
			// 로그인 성공
			
			//	로그인 여부를 true로
			isLogin = true;
			
			//	session에 id를 저장
			//	로그인여부를 저장
			ss.setAttribute("id", mdto.getMemberId());
			ss.setAttribute("isLogin", isLogin);
			
			//	main으로 이동
			return new ModelAndView("main");
		}else {
			//	로그인여부를 false로
			isLogin=false;
			//	로그인 여부를 세션에 저장
			ss.setAttribute("isLogin", isLogin);
			
			return new ModelAndView("login","isFail",true);
		}

	}
	
	//	로그아웃시도
	@RequestMapping(value="/logout")
	public String logout(HttpSession ss) {
		isLogin=false;
		ss.setAttribute("isLogin", isLogin);
		ss.removeAttribute("id");		
		return "main";
	}

}
