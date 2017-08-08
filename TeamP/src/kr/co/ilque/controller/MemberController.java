package kr.co.ilque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//마이페이지에서의 페이지 이동

@Controller
public class MemberController {
	
	//	[수정]버튼 누르면 정보 수정하기
	//	id값으로 기존 정보를 불러와서 미리 채워놓고 수정한 값을 db에 update한다
	//	작성 후엔 마이페이지로 다시 이동.
	@RequestMapping("/modify")
	public String modify() {
		return "redirect:/myPage";
		
	}

}
