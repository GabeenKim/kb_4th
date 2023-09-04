package com.service.spring.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.UploadDataVO;

@Controller
public class FileUploadController {
	
	@RequestMapping("fileupload.do")
	public String upload(UploadDataVO vo, Model model, HttpSession session) throws Exception{
		
		MultipartFile mFile= vo.getUploadFile();
		System.out.println("MultipartFile :: "+mFile);
		
		//MultipartFile의 주요 기능...
		if(mFile.isEmpty()!=true) {
			//즉 파일이 선택 됐다면. 업로드 된 파일이 있다면..~
			System.out.println("파일의 사이즈 : "+mFile.getSize());
			System.out.println("업로드 한 파일의 이름 : "+mFile.getOriginalFilename()); //파일명 찾아오기 - getName아님!!!!!OriginalFileName임
			System.out.println("mFile.getName() ???? : "+mFile.getName());
		}
		//업로드 한 파일을 Tomcat 서버로 배포(저장) -> 경로 연결 webapp 밑에 upload 폴더 
		String root = session.getServletContext().getRealPath("/"); //이게 ContextPath임. 
		System.out.println("root :: "+ root);
		
		String path = root+"upload\\";  // \\해줘야 파일이 붙을 수 있음. 
		System.out.println("path :: "+path);
		
		//업로드한 파일의 카피본을 해당 경로 /upload에 저장 
		File copyFile = new File(path+mFile.getOriginalFilename());
		mFile.transferTo(copyFile);
		
		model.addAttribute("uploadfile",mFile.getOriginalFilename());
		return "upload_result";
	}
	
	@RequestMapping("filedown.do")
	public String download(String filename,Model model ,HttpSession session) throws Exception{
		
		//vo에 path와 filename만 이름 맞추기
		String root = session.getServletContext().getRealPath("/");
		String path = root + "upload\\";
		
		model.addAttribute("path", path);
		return "downloadView";
	
	}
}
