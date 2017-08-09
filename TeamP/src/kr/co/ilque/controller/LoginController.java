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
	public String tryLogin(@RequestParam("id") String memberId, @RequestParam("pw") String memberPwd,
			HttpServletRequest req, HttpSession ss) {

		System.out.println("id,pw = " + memberId + "," + memberPwd);
		System.out.println("url:" + req.getParameter("url"));

		// 로그인
		// 로그인 성공: 세션에 로그인 정보.
		MemberDto dto = new MemberDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		if (sv.chkLogin(dto) != null) {
			// 로그인 성공
			isLogin = true;
			ss.setAttribute("id", memberId);
		}
		ss.setAttribute("isLoin", isLogin);

		return req.getHeader("referer");
	}

}
