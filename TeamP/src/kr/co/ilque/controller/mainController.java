package kr.co.ilque.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mainController {

	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "board";
	}
	@RequestMapping("/imgPutForm")
	public String imgPutForm() {
		return "imgPutForm";
	}
	@RequestMapping("/imgPutOk")
	public ModelAndView imgPutOk(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("img","img");
		mav.setViewName("writeForm");
		return mav;
	}
	
}
