package kr.co.ilque.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ilque.dto.MemberDto;
import kr.co.ilque.service.UserService;
import kr.co.ilque.controller.UploadFile;

//	�쉶�썝媛��엯 �솕硫댁뿉�꽌�쓽 �솕硫댁씠�룞
@Controller
public class JoinController {
	@Resource(name = "userService")
	UserService us;

	public void setUs(UserService us) {
		this.us = us;
	}

	// �쉶�썝媛��엯踰꾪듉�쓣 �늻瑜대㈃ memberDTO�� isJoin=1�쓣 媛�吏�怨� 濡쒓렇�씤�럹�씠吏�濡�
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String joinOk(@RequestParam("memberId") String memberId, @RequestParam("memberPwd") String memberPwd,
			@RequestParam("memberName") String memberName, @RequestParam("filePath") String profileSrc,
			@RequestParam("phone") String phone, @RequestParam("gender") String gender,
			@RequestParam("birth") String birth, @RequestParam("contents") String contents,
			@ModelAttribute("uploadFile") UploadFile file, HttpServletRequest req, BindingResult result) {
		MemberDto dto = new MemberDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		dto.setMemberName(memberName);
		dto.setProfileSrc(profileSrc);
		dto.setGender(gender);
		dto.setPhone(phone);
		dto.setContents(contents);
		System.out.println(profileSrc);
		// contents?
		dto.setBirth(birth);
		
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
		File f = new File(filePath + "/" +memberId+fileName);
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
		dto.setProfileSrc(f.getName());
		
		us.insertOne(dto);
		req.setAttribute("isJoin", true);
		return "login";
	}

}
