package kr.co.ilque.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.dto.ReviewDto;
import kr.co.ilque.service.ReviewService;

@Controller
public class ReviewController {
	@Resource(name="reviewService")
	ReviewService rs;
	
	//	리뷰는 회원이 직접 수정/삭제가 불가능	
	
	//	리뷰작성폼으로 이동
	@RequestMapping("/writeReview")
	public ModelAndView writeReview(@RequestParam("boardNo")int boardNo,
									@RequestParam("applicants")String applicants,
									HttpSession ss){
		//	글의 지원자가 로그인된 이용자와 같은지 확인
		if(ss.getAttribute("id").equals(applicants)) {
			//	같으면 리뷰 작성가능
			return new ModelAndView("reviewForm","boardNo",boardNo);		
		}else{
			//	아닌데 접근했을 경우 해당 글로 리다이렉트함
			return new ModelAndView("redirect:/Detail?boardNo="+boardNo);
		}
	}

	//	리뷰등록
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
