package kr.co.ilque.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.dto.BoardDto;
import kr.co.ilque.service.BoardService;
import kr.co.ilque.service.CommentsService;

@Controller
public class BoardController {
	@Resource(name="boardService")
	BoardService bs;
	@Resource(name="commentsService")
	CommentsService cs;
/*	@Resource(name="loginService")
	LoginService ls;
	*/

	public void setBs(BoardService bs) {
		this.bs = bs;
	}

	public void setCs(CommentsService cs) {
		this.cs = cs;
	}

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

	// 작성 버튼 누르면 글 작성 정보를 가지고 글 상세페이지로 넘어감
	@RequestMapping(value = "/writeOk", method = RequestMethod.POST)
	public String writeOk(
			@RequestParam("category")String category,
			@RequestParam("title")String title,
			@RequestParam("contents")String contents,
			@RequestParam("reward")int reward,
			@RequestParam("phone")String phone,
			@RequestParam("time")String time,
			@RequestParam("sample6_postcode")String postCode,
			@RequestParam("sample6_address")String address,
			@RequestParam("sample6_address2")String address2,
			HttpSession ss) {
		
		System.out.println("writeOk 진입");
		BoardDto bdto= new BoardDto();
		String writer = (String) ss.getAttribute("id");//writer에 세션에서 아이디 받아와서 저장
		String loc = address+" "+address2+" (우)"+postCode;

		
		
		System.out.println("writer:"+writer);
		System.out.println("category:"+category);
		System.out.println("title:"+title);
		System.out.println("contents:"+contents);
		System.out.println("reward:"+reward);
		System.out.println("phone:"+phone);
		System.out.println("time:"+time);
		System.out.println("postCode:"+postCode);
		System.out.println("address:"+address);
		System.out.println("address2:"+address2);
		
		bdto.setCategory(category);
		bdto.setTitle(title);
		bdto.setContents(contents);
		bdto.setWriter(writer);
		bdto.setLoc(loc);
		bdto.setTime(time);
		bdto.setPhone(phone);
		bdto.setReward(reward);
		bdto.setApplicant("");
		
	
		
		System.out.println();
		
		
		//임력후 다시 리스트를 출력시킨다.
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
	
	@RequestMapping("/commentDelete")
	public String userDetail2(@RequestParam(name = "commentNo") int commentNo,
			@RequestParam(name = "boardNo") int boardNo) {
		cs.commentDel(commentNo);
		return "redirect:detail?boardNo=" + boardNo;
		// "userDetail?id="+id
	}

}