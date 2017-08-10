package kr.co.ilque.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.service.BoardService;
import kr.co.ilque.service.CommentsService;

@Controller
public class BoardController {
	@Resource(name="boardService")
	BoardService bs;
	@Resource(name="commentsService")
	CommentsService cs;

	// 거래목록에서 글 누르면 상세페이지로 넘어감
	// bno를 통하여 db에서 글의 상세정보 가져오기
	@RequestMapping(value = "/detail",method = RequestMethod.GET)
	public ModelAndView showDetail(@RequestParam(name="boardNo") int boardNo) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("dvdto", bs.read(boardNo));
		mav.addObject("list", cs.read(boardNo));
		mav.setViewName("detail");
		
		
		return mav;
		// "detail?bno="+bno;
	}

	// 작성 버튼 누르면 글 작성 정보를 가지고 글 상세페이지로 넘어감
	@RequestMapping(value = "/writeOk", method = RequestMethod.POST)
	public String writeOk() {
		return null;
		// "detail?bno="+bno;
	}

	// 유저 사진을 클릭하면 유저 상세페이지로 넘어감
	// 유저 id를 가지고 가서 db에서 유저 상세페이지 가져오기
	// 자기 페이지가 아닐 경우 휴대폰번호와 이름은 일정부분 필터링(성**, 0101234****)
	@RequestMapping("/userDetail")
	public String userDetail() {
		return "userDetail";
		// "userDetail?id="+id
	}

}
