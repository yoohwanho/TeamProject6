package kr.co.ilque.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.service.BoardService;
import kr.co.ilque.service.KeywordsService;

@Controller
public class ListController {

	@Resource(name = "boardService")
	BoardService bs;
	@Resource(name = "keywordsService")
	KeywordsService ks;

	public void setBs(BoardService bs) {
		this.bs = bs;
	}
	

	public void setKs(KeywordsService ks) {
		this.ks = ks;
	}


	@RequestMapping("/board")
	public ModelAndView list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(name = "CountPerPage", defaultValue = "10") int CountPerPage,
			HttpServletRequest req
			) {
		String keyword = null;
		String gender = null;
		String category = null;
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
		System.out.println(req.getParameter("keyword"));
		if(req.getParameter("keyword")!=null) {
			System.out.println("키워드체크:"+ks.check(req.getParameter("keyword")).isEmpty());
			if(ks.check(req.getParameter("keyword")).isEmpty()) {
				ks.add(req.getParameter("keyword"));
			}else {
				ks.update(req.getParameter("keyword"));
			}
			System.out.println("키워드조회");
			keyword = '%'+req.getParameter("keyword")+'%';
		}
		if(req.getParameter("category")!=null) {
			category = '%'+req.getParameter("category")+'%';
		}
		if(req.getParameter("gender")!=null) {
			gender = '%'+req.getParameter("gender")+'%';
		}
		/*else if(){
		
		}*/
		
		mav.addObject("list", bs.leadAll(startNo, endNo,keyword,category,gender));
		mav.setViewName("board");
		return mav;

	}
}
