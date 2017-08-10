package kr.co.ilque.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.dto.ReviewDto;
import kr.co.ilque.service.ReviewService;
import kr.co.ilque.controller.UploadFile;

@Controller
public class ReviewController {
	@Resource(name="reviewService")
	ReviewService rs;
	
	//	由щ럭�뒗 �쉶�썝�씠 吏곸젒 �닔�젙/�궘�젣媛� 遺덇��뒫	
	
	//	由щ럭�옉�꽦�뤌�쑝濡� �씠�룞
	@RequestMapping("/writeReview")
	public ModelAndView writeReview(@RequestParam("boardNo")int boardNo,
									@RequestParam("applicants")String applicants,
									HttpSession ss){
		//	湲��쓽 吏��썝�옄媛� 濡쒓렇�씤�맂 �씠�슜�옄�� 媛숈�吏� �솗�씤
		if(ss.getAttribute("id").equals(applicants)) {
			//	媛숈쑝硫� 由щ럭 �옉�꽦媛��뒫
			return new ModelAndView("reviewForm","boardNo",boardNo);		
		}else{
			//	�븘�땶�뜲 �젒洹쇳뻽�쓣 寃쎌슦 �빐�떦 湲�濡� 由щ떎�씠�젆�듃�븿
			return new ModelAndView("redirect:/Detail?boardNo="+boardNo);
		}
	}

	//	由щ럭�벑濡�
	@RequestMapping("/reviewOk")
	public String writeReview(
			HttpSession ss,
			@RequestParam("boardNo")int boardNo,
			@RequestParam("contents")String contents,
			@RequestParam("imgSrc")String imgSrc,
			@RequestParam("score")int score,
			@ModelAttribute("uploadFile")UploadFile file, 
			HttpServletRequest req,
			BindingResult result
			) {
		ReviewDto rdto = new ReviewDto();
		rdto.setBoardNo(boardNo);
		rdto.setRWriter((String)ss.getAttribute("id"));
		rdto.setContents(contents);
		
		rdto.setScore(score);
		MultipartFile mfile = file.getFile();
		//vaildate 추후 추가 가능
		
		HttpSession hs = req.getSession();
		ServletContext application = hs.getServletContext();

		String filePath = application.getRealPath("/data");
		// data폴더에 저장하고싶다 -> 실제경로를 알아오자
		System.out.println("실제경로:" + filePath);

		// 파일의 원본이름
		String fileName = mfile.getOriginalFilename();

		// 파일객체생성
		File f = new File(filePath + "/" +(String)ss.getAttribute("id")+fileName);
		//경로에있는 파일에 mfile을 복사해
		//파일이름 겹칠수도 있자나...파일 이름은 id+파일이름으로 한다.
		
		try {
			mfile.transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//	db�뿉 �벑濡�
		rdto.setImgSrc(f.getName());
		rs.writeReview(rdto);		
			
		return "redirect:/detail?boardNo="+boardNo;
	}

}
