package kr.co.ilque.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	FileValidator fileValidator;

	public void setFileValidator(FileValidator fileValidator) {
		this.fileValidator = fileValidator;
	}

	@RequestMapping("/imgPutForm")
	public String imgPutForm() {
		return "imgPutForm";
	}
	@RequestMapping("/imgPutForm2")
	public String imgPutForm2() {
		return "imgPutForm2";
	}
	
	@RequestMapping("/imgPutForm3")
	public String imgPutForm3() {
		return "imgPutForm3";
	}


	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView upload(@ModelAttribute("uploadFile") UploadFile file, HttpServletRequest req,
			BindingResult result) {  
		// 업로드한 파일 객체 가져오기
		// 내부적으로 임의의 경로에 파일을 보관
		MultipartFile mfile = file.getFile();
		

		// 파일 유효성 검사후 성공하면 작업 계속
		// 실패하면 중단
		/*
		 * fileValidator.validate(file, result); if (result.hasErrors()) { return new
		 * ModelAndView("imgPutForm"); }
		 */

		// 파일은 어디에 저장?
		HttpSession hs = req.getSession();
		ServletContext application = hs.getServletContext();
		String filePath = application.getRealPath("/data");
		// 파일의 원본 이름
		String fileName = mfile.getOriginalFilename();
		// 파일 객체
		File f = new File(filePath + "/" + fileName);
		// 임시파일에 보관중인 파일을 저장
		// 복사
		try {
			mfile.transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("fileName", f.getName());
		mav.addObject("filePath", "./data/" + f.getName());
		mav.setViewName("join");
		return mav;
	}

	@RequestMapping(value = "/reviewPic", method = RequestMethod.POST)
	public ModelAndView uploadReviewPic(@ModelAttribute("uploadFile") UploadFile file, HttpServletRequest req,
			BindingResult result) {
		// 업로드한 파일 객체 가져오기
		// 내부적으로 임의의 경로에 파일을 보관
		MultipartFile mfile = file.getFile();
		System.out.println("file : " + file);

		// 파일 유효성 검사후 성공하면 작업 계속
		// 실패하면 중단
		/*
		 * fileValidator.validate(file, result); if (result.hasErrors()) { return new
		 * ModelAndView("imgPutForm"); }
		 */

		// 파일은 어디에 저장?
		HttpSession hs = req.getSession();
		ServletContext application = hs.getServletContext();
		String filePath = application.getRealPath("/data");
		System.out.println("실제 파일이 저장되는 경로 : " + filePath);
		// 파일의 원본 이름
		String fileName = mfile.getOriginalFilename();
		// 파일 객체
		File f = new File(filePath + "/" + fileName);
		// 임시파일에 보관중인 파일을 저장
		// 복사
		try {
			mfile.transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("fileName", f.getName());
		mav.addObject("filePath", "./data/" + f.getName());
		mav.setViewName("reviewForm");
		return mav;
	}
	

	@RequestMapping(value = "/modifyPic", method = RequestMethod.POST)
	public ModelAndView modifyPic(@ModelAttribute("uploadFile") UploadFile file, HttpServletRequest req,
			BindingResult result) {
		// 업로드한 파일 객체 가져오기
		// 내부적으로 임의의 경로에 파일을 보관
		MultipartFile mfile = file.getFile();
		System.out.println("file : " + file);

		// 파일 유효성 검사후 성공하면 작업 계속
		// 실패하면 중단
		/*
		 * fileValidator.validate(file, result); if (result.hasErrors()) { return new
		 * ModelAndView("imgPutForm"); }
		 */

		// 파일은 어디에 저장?
		HttpSession hs = req.getSession();
		ServletContext application = hs.getServletContext();
		String filePath = application.getRealPath("/data");
		System.out.println("실제 파일이 저장되는 경로 : " + filePath);
		// 파일의 원본 이름
		String fileName = mfile.getOriginalFilename();
		// 파일 객체
		File f = new File(filePath + "/" + fileName);
		// 임시파일에 보관중인 파일을 저장
		// 복사
		try {
			mfile.transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("fileName", f.getName());
		mav.addObject("filePath", "./data/" + f.getName());
		mav.setViewName("userModify");
		return mav;
	}
	
	
	

}
