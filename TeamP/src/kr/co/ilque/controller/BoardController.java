package kr.co.ilque.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.dto.BoardDto;
import kr.co.ilque.dto.CommentsDto;
import kr.co.ilque.dto.DetailViewDto;
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
		String loc = address+" "+address2+" "+postCode;

		
		
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
		
		bs.insertOne(bdto);
		//임력후 다시 리스트를 출력시킨다.
		return null;
		// "detail?bno="+bno;
	}


	@RequestMapping("/commentDelete")
	public String commentDel(@RequestParam(name = "commentNo") int commentNo,
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
	@RequestMapping("/deleteBoard")
	public String deleteOne(@RequestParam(name="boardNo") int boardNo) {
		bs.deleteOne(boardNo);
		return "redirect:board";
	}
	
	@RequestMapping("/modifyBoard")
	public ModelAndView modifyBoard(@RequestParam(name="boardNo") int boardNo) {
		String[] loc = new String[3];
		ModelAndView mav = new ModelAndView();
		DetailViewDto dvdto = bs.read(boardNo);
		if(dvdto.getLoc().contains(" ")) {
			loc=dvdto.getLoc().split(" ");			
		}else {
			//	★이 포함되어있지 않은 샘플데이터 처리
			loc[0]="테";
			loc[1]="스";
			loc[2]="트";
		}
		
		mav.addObject("dvdto", dvdto);
		
		System.out.println(loc[0]);
		System.out.println(loc[1]);
		System.out.println(loc[2]);
		mav.addObject("sample6_address1",loc[0]);
		mav.addObject("sample6_address2",loc[1]);
		mav.addObject("sample6_postcode", loc[2]);
		mav.setViewName("modifyForm");
		return mav;
	}

}
