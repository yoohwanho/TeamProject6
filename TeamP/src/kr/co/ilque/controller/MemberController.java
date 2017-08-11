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
import kr.co.ilque.service.LoginService;
import kr.co.ilque.service.UserService;
import kr.co.ilque.controller.FileValidator;
import kr.co.ilque.controller.UploadFile;

//留덉씠�럹�씠吏��뿉�꽌�쓽 �럹�씠吏� �씠�룞

@Controller
public class MemberController {
	FileValidator f;
	@Resource(name = "userService")
	UserService us;
	
	@Resource(name="loginService")
	LoginService ls;

	public void setUs(UserService us) {
		this.us = us;
	}
	
	

	public void setLs(LoginService ls) {
		this.ls = ls;
	}



	// [�닔�젙]踰꾪듉 �늻瑜대㈃ �젙蹂� �닔�젙�븯湲�
	// id媛믪쑝濡� 湲곗〈 �젙蹂대�� 遺덈윭���꽌 誘몃━ 梨꾩썙�넃怨� �닔�젙�븳 媛믪쓣 db�뿉 update�븳�떎
	// �옉�꽦 �썑�뿏 留덉씠�럹�씠吏�濡� �떎�떆 �씠�룞.@RequestMapping("/modify")
	@RequestMapping(value="/modifyForm", method=RequestMethod.POST)
	public ModelAndView goModifyForm(
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPwd") String memberPwd,
			@RequestParam("memberName") String memberName,
			@RequestParam("profileSrc") String profileSrc,
			@RequestParam("phone") String phone,
			@RequestParam("contents") String contents,
			@RequestParam("gender") String gender			
			) {
		
		MemberDto dto = new MemberDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		dto.setMemberName(memberName);
		dto.setProfileSrc(profileSrc);
		dto.setGender(gender);
		dto.setPhone(phone);
		dto.setContents(contents);
		ls.pickMemberInfo(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("mdto", dto);
		mav.setViewName("userModify");
		
		
		return mav;
	}

	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ModelAndView modify(@RequestParam("memberId") String memberId, @RequestParam("memberPwd") String memberPwd,
			@RequestParam("memberName") String memberName, @RequestParam("phone") String phone,
			@RequestParam("gender") String gender, @RequestParam("filePath") String profileSrc,
			@RequestParam("contents") String contents,
			@ModelAttribute("uploadFile")UploadFile file, 
			HttpServletRequest req,
			BindingResult result
			
			) {

		MemberDto dto = new MemberDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		dto.setMemberName(memberName);
		dto.setProfileSrc(profileSrc);
		dto.setGender(gender);
		dto.setPhone(phone);
		dto.setContents(contents);
		MultipartFile mfile = file.getFile();
		//vaildate 추후 추가 가능
		f.validate(file,result);
		if(result.hasErrors()) {
			System.out.println("여기서끝난다");
			System.out.println(result.getFieldValue("file"));
			return new ModelAndView("upload/uploadForm");
		}
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
		us.updateOne(dto);
		ls.pickMemberInfo(dto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("mdto",dto);
		mav.setViewName("userDetail");

		return mav;

	}

}
