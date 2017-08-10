package kr.co.ilque.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.service.BoardService;

@Controller
public class ListController {

	@Resource(name = "boardService")
	BoardService bs;

	public void setBs(BoardService bs) {
		this.bs = bs;
	}

	@RequestMapping("/board")
	public ModelAndView list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(name = "CountPerPage", defaultValue = "10") int CountPerPage) {
		ModelAndView mav = new ModelAndView();
		int total = bs.getTotal();
		int startNo = (currentPage - 1) * CountPerPage + 1;
		int endNo = currentPage * CountPerPage;
		int totalPage = total % CountPerPage == 0 ? total / CountPerPage : total / CountPerPage + 1;
		int startPage = currentPage - 5 <= 0 ? 1 : currentPage - 5;
		int endPage = startPage + 10 >= totalPage ? totalPage : startPage + 9;
		boolean prev = currentPage > 5 ? true : false;
		boolean next = currentPage + 5 >= totalPage ? false : true;
		mav.addObject("currentPage", currentPage);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		mav.addObject("prev", prev);
		mav.addObject("next", next);
		mav.addObject("list", bs.leadAll(startNo, endNo));
		mav.setViewName("board");
		return mav;

	}
}
