package kr.co.ilque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		/*System.out.println("검사 대상 : " + target);*/
		// 이떄 발생하는 에러 : errors
		
		UploadFile file = (UploadFile) target;
		MultipartFile mf = file.getFile();
		if(mf.getSize() == 0 ) {
			errors.rejectValue("file", null, "파일을 선택해주세요");
		}else if(mf.getSize()>104857600) {
			errors.rejectValue("file", null, "100M 이하의 파일만 전송가능합니다.");
		}
		
	}

}
