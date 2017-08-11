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
import kr.co.ilque.service.KeywordsService;
import kr.co.ilque.service.LoginService;

//	�꺆�쑝濡� �뼵�젣�뱺吏� �젒洹쇳븷 �닔 �엳�뒗 踰꾪듉�뿉 �쓽�븳 �럹�씠吏��씠�룞.

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

	
	//	硫붿씤 �럹�씠吏�
	@RequestMapping("/main")
	public ModelAndView main(HttpSession ss) {
		if(ss.getAttribute("isLogin")==null) {
			//	isLogin�씠 null�씪 寃쎌슦 �궗�씠�듃�뿉 泥� �젒洹쇱쑝濡� �뙋�떒�븯�뿬 isLogin�쓣 false濡�
			isLogin=false;
			//	�꽭�뀡�뿉 ���옣�븳�떎
			ss.setAttribute("isLogin", isLogin);
		}
		return new ModelAndView("main","list",ks.select10());
	}
	
	//	[濡쒓렇�씤] �럹�씠吏�濡� �꽆�뼱媛�
	@RequestMapping("/login")
	public ModelAndView login(HttpSession ss, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("login");
		

		//	濡쒓렇�씤 �떎�뙣硫붿떆吏�瑜� �쓣�슱吏� �뙋蹂�
		boolean isFail=false;
		if(req.getParameter("isFail")!=null) {
			//	isFail�씠 null�씠 �븘�땲怨� true媛믪씠 �엳�떎硫� isFail�뿉 true
			if(req.getParameter("isFail").equals("true")) {
				isFail=true;
				mav.addObject("isFail",isFail);
			}
		}
		
		//	�쉶�썝媛��엯�럹�씠吏��뿉�꽌 �씠�룞�뻽�뒗吏� �뙋蹂�
		boolean isJoin=false;
		if(req.getParameter("isJoin")!=null) {
			//	isJoin�씠 null�씠 �븘�땲怨� true媛믪씠 �엳�떎硫� true
			if(req.getParameter("isJoin").equals("true")) {
				isJoin=true;
				mav.addObject("isJoin",isJoin);
			}
		}
		
		//	濡쒓렇�븘�썐�긽�깭�뿉�꽌 �젒洹쇳뻽�뒗吏� �뙋蹂�
		boolean isAccess=false;
		if(req.getParameter("isAccess")!=null) {
			//	isAccess�씠 null�씠 �븘�땲怨� true媛믪씠 �엳�떎硫� isAccess�뿉 true
			if(req.getParameter("isAccess").equals("true")) {
				isAccess=true;
				mav.addObject("isAccess",isAccess);
			}
		}
		
		
		//濡쒓렇�씤 �뿬遺�瑜� �뙋蹂�
		boolean isLogin = (boolean)ss.getAttribute("isLogin");
		if(!isLogin) {
			//	濡쒓렇�븘�썐 �긽�깭: 濡쒓렇�씤�럹�씠吏�濡�
			mav.setViewName("login");
			return mav;
		}else{
			//	濡쒓렇�씤 �긽�깭: 硫붿씤�쑝濡�
			
			mav.setViewName("redirect:/main");
			return mav;
		}
	}
	
	//	濡쒓렇�씤 �븯硫� �꽭�뀡�뿉 濡쒓렇�씤 �젙蹂대�� ���옣�븯怨좎씠�쟾�럹�씠吏�濡� �꽆�뼱媛�
	//	menu�뿉�꽌 [濡쒓렇�씤]踰꾪듉怨� [�쉶�썝媛��엯]踰꾪듉�쓣 �뾾�븷怨� [濡쒓렇�븘�썐]踰꾪듉怨� [留덉씠�럹�씠吏�]踰꾪듉�씠 蹂댁씠�룄濡� �븿
	
	//	(濡쒓렇�씤 �긽�깭�씪�븣)濡쒓렇�븘�썐 踰꾪듉�쓣 �늻瑜대㈃ �꽭�뀡�뿉�꽌 濡쒓렇�씤 �젙蹂대�� 吏��슦怨� �럹�씠吏� �쑀吏�
	//	menu�쓽 [濡쒓렇�븘�썐]踰꾪듉怨� [留덉씠�럹�씠吏�]踰꾪듉�쓣 [濡쒓렇�씤]踰꾪듉怨� [�쉶�썝媛��엯]踰꾪듉�쑝濡� 諛붽퓞
//		return 	"redirect:/(�쁽�옱�럹�씠吏�)";
	
	//	(濡쒓렇�븘�썐 �긽�깭�씪�븣)�쉶�썝媛��엯 �럹�씠吏�濡� �꽆�뼱媛�
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(HttpSession ss) {
		boolean isLogin = (boolean)ss.getAttribute("isLogin");
		
		if(!isLogin) {
			return "join";			
		}else {
			//	濡쒓렇�씤 �긽�깭�뿉�꽌 �젒洹쇳븷 寃쎌슦 硫붿씤�럹�씠吏�濡� �씠�룞
			return "redirect:/main";
		}
	}

	//	[�빐二쇱꽭�슂/�빐�뱶由쎈땲�떎] �늻瑜대㈃ 湲� �옉�꽦 �럹�씠吏�濡� �꽆�뼱媛�
	@RequestMapping("/write")
	public ModelAndView writeForm(HttpSession ss) {
		boolean isLogin = (boolean)ss.getAttribute("isLogin");
		
		if(!isLogin) {
			//濡쒓렇�븘�썐�긽�깭�씪 寃쎌슦 濡쒓렇�씤�솕硫댁쑝濡� �씠�룞
			return new ModelAndView("redirect:/login","isAccess",true);
		}else{
			return new ModelAndView("writeForm");
		}
	}
	
	//	[留덉씠�럹�씠吏�]
	@RequestMapping("/myPage")
	public ModelAndView showMyPage( HttpSession ss ) {
		boolean isLogin = (boolean)ss.getAttribute("isLogin");
		
		if(!isLogin) {
	
			//濡쒓렇�븘�썐�긽�깭�씪 寃쎌슦 濡쒓렇�씤�솕硫댁쑝濡� �씠�룞
			return new ModelAndView("login","isAccess",true);
		}else{
			//	濡쒓렇�씤 �긽�깭�씪 寃쎌슦 �씠�룞
			//	硫ㅻ쾭媛앹껜 �깮�꽦
			MemberDto mdto = new MemberDto();
			
			//	session�뿉 ���옣�맂 id瑜� 硫ㅻ쾭媛앹껜�뿉 set
			if(ss.getAttribute("id")!=null) {
				mdto.setMemberId((String)ss.getAttribute("id"));			
			}
			System.out.println(mdto.getMemberId());
			//	id媛� ���옣�맂 硫ㅻ쾭媛앹껜濡� 愿��젴 �젙蹂� �떞�븘�삤湲�
			//	LoginService ls = new LoginService();
			mdto=ls.pickMemberInfo(mdto);
			mdto.setProfileSrc("./data/"+mdto.getProfileSrc());
			
			
			return new ModelAndView("userDetail","mdto",mdto);
		}
	}
	@RequestMapping("/memberPage")
	public ModelAndView showMemberPage(@RequestParam("id") String id,HttpSession ss) {
		boolean isLogin = (boolean)ss.getAttribute("isLogin");
		
		if(!isLogin) {
	
			
			return new ModelAndView("login","isAccess",true);
		}else{

			MemberDto mdto = new MemberDto();
			mdto.setMemberId(id);
			mdto=ls.pickMemberInfo(mdto);
			mdto.setProfileSrc("./data/"+mdto.getProfileSrc());
			
			
			return new ModelAndView("userDetail","mdto",mdto);
		}
	}
}
