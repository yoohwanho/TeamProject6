package kr.co.ilque.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.dto.CommentsDto;
import kr.co.ilque.service.BoardService;
import kr.co.ilque.service.CommentsService;

@Controller
public class BoardController {
	@Resource(name = "boardService")
	BoardService bs;
	@Resource(name = "commentsService")
	CommentsService cs;

	// 거래목록에서 글 누르면 상세페이지로 넘어감
	// bno를 통하여 db에서 글의 상세정보 가져오기
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView showDetail(@RequestParam(name = "boardNo") int boardNo) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("dvdto", bs.read(boardNo));
		mav.addObject("list", cs.read(boardNo));
		mav.addObject("commentTotal", cs.total(boardNo));
		mav.setViewName("detail");

		return mav;
		// "detail?bno="+bno;
	}
	
	@RequestMapping("/commentDelete")
	public String userDetail2(@RequestParam(name = "commentNo") int commentNo,
			@RequestParam(name = "boardNo") int boardNo) {
		cs.commentDel(commentNo);
		return "redirect:detail?boardNo=" + boardNo;
		// "userDetail?id="+id
	}

	@RequestMapping("/writecomments")
	public String commentIn(@RequestParam(name = "comments") String comments,
			@RequestParam(name = "boardNo") int boardNo, @RequestParam(name = "id") String id) {
		CommentsDto dto = new CommentsDto();
		dto.setBoardNo(boardNo);
		dto.setContents(comments);
		dto.setWriter(id);
		cs.commentWrite(dto);

		return "redirect:detail?boardNo=" + boardNo;
	}

}
