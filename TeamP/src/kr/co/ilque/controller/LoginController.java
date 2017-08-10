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

@Controller
public class LoginController {
	@Resource(name="loginService")
	LoginService ls;
	

	@RequestMapping(value = "/tryLogin", method = RequestMethod.POST)
	public ModelAndView tryLogin(@RequestParam("id") String memberId, @RequestParam("pw") String memberPwd,
								@RequestParam("url") String url, HttpServletRequest req, HttpSession ss
								) {

		boolean isLogin = (boolean)ss.getAttribute("isLogin");
		
		if(!isLogin) {
			//로그아웃상태일 경우 로그인화면으로 이동
			String[] temp=url.split("/");
			String jspUrl =temp[temp.length-1];

			// 로그인
			// 로그인 성공: 세션에 로그인 정보.
			MemberDto mdto = new MemberDto();
			mdto.setMemberId(memberId);
			mdto.setMemberPwd(memberPwd);
			if ( ls.chkLogin(mdto)!=null) {
				// 로그인 성공
				
				//	로그인 여부를 true로
				isLogin = true;
				
				//	session에 id를 저장
				//	로그인여부를 저장
				ss.setAttribute("id", mdto.getMemberId());
				System.out.println("로그인성공후 mdto에서 가져온 id: "+mdto.getMemberId());
				ss.setAttribute("isLogin", isLogin);
				
				//	요청이 write인 경우 writeForm.jsp로 이동
//				if(jspUrl.equals("write"))
//				{
//					jspUrl = "writeForm";
//				}
				
				//	main으로 이동
				return new ModelAndView("redirect:/"+jspUrl);
			}else {
				//	아이디나 비밀번호가 맞지 않을때				
				return new ModelAndView("redirect:/login","isFail",true);
			}
		}else{
			return new ModelAndView("redirect:/main");
		}
	}
	
	//	로그아웃시도
	@RequestMapping(value="/logout")
	public String logout(HttpSession ss) {
		boolean isLogin = (boolean)ss.getAttribute("isLogin");
		
		if(!isLogin) {		
			return "redirect:/main";
		}else{
			isLogin=false;
			ss.setAttribute("isLogin", isLogin);
			ss.removeAttribute("id");
			return "redirect:/main";
		}
		
	}

}
