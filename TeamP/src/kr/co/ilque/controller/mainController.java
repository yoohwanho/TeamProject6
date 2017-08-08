package kr.co.ilque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value = "/join", method = RequestMethod.GET)
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
	
}
