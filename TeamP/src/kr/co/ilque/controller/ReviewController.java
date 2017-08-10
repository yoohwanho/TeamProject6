package kr.co.ilque.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ilque.dto.ReviewDto;
import kr.co.ilque.service.ReviewService;

@Controller
public class ReviewController {
	@Resource(name="reviewService")
	ReviewService rs;
	
	@RequestMapping("/reviewOk")
	public String writeReview(
			HttpSession ss,
			@RequestParam("boardNo")int boardNo,
			@RequestParam("contents")String contents,
			@RequestParam("imgSrc")String imgSrc,
			@RequestParam("score")int score
			) {
		ReviewDto rdto = new ReviewDto();
		rdto.setBoardNo(boardNo);
		rdto.setRWriter((String)ss.getAttribute("id"));
		rdto.setContents(contents);
		rdto.setImgSrc(imgSrc);
		rdto.setScore(score);
		
		//	db에 등록
		rs.writeReview(rdto);		
			
		return "redirect:/detail?boardNo="+boardNo;
	}

}
