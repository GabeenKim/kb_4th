package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneService;

@Controller
public class PhoneController {
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("/") //http://127.0.0.1:9999/ -> boot 부터는 context-path가 안 잡혀서 해당 주소로 매핑됨.
	public String index() {
		return "redirect:index.jsp"; //redirect는 웹으로부터 다시 뽑아내는 것이므로 뷰리졸버를 거치지 않음. 따라서 무조건 확장자 붙여주기.
	}
	
	//등록 폼 결과 페이지를 띄우기 위해서 get을 붙임.
	@GetMapping("/regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title","핸드폰 관리 - 핸드폰 등록 폼");
		return "PhoneReg";
		
	}
	
	//등록 페이지 내에서 등록, 삭제, 조회 등 실제 행위를 하기 때문에 do를 붙였음. 
	@PostMapping("/savePhone.do")
	public String doRegPhone(Phone phone, Model model) {
		try {
			//성공 페이지
			System.out.println("phone service inert before");
			phoneService.insert(phone);
			System.out.println("phone service inert after");
			model.addAttribute("title","핸드폰 관리 - 핸드폰 저장 성공");
			return "Result";
			
		} catch (Exception e) {
			//에러 페이지
			System.out.println(e);
			model.addAttribute("title","핸드폰 관리 - 핸드폰 저장 에러");
			return "Error";
		}
	}
	
	@GetMapping("/searchPhone.do")
	public String doList(Model model) {
		try {
			List<Phone> phones = phoneService.select();
			model.addAttribute("phones",phones);
			model.addAttribute("title","핸드폰 관리 - 핸드폰 목록 리스트");
			return "PhoneList";
			
		} catch (Exception e) {
			model.addAttribute("title","핸드폰 관리 - 에러");
			model.addAttribute("message","문제 내용 - 폰 목록 조회 중 에러 발생...");
			return "Error";
		}
	}
	
	//비동기 일때는 데이터가 리턴된다. 따라서 ResponseBody를 꼭해줘야 함/
	//param으로 전달했기에 requestParam으로 받고  param 안에  num이 여러개가 들어있기에 List 형식의 num을 지정해줘야 함. 
	@PostMapping("/deleteAjax.do")
	@ResponseBody
	public String doAjaxDelete(Model model,@RequestParam List<String> num){
		List<String> temp =new ArrayList();
		try {
			for(String n: num) temp.add(n);
			phoneService.delete(temp);
			return "";
		} catch (Exception e) {
			model.addAttribute("title","핸드폰 관리 - 에러");
			model.addAttribute("message","문제 내용 - 폰 삭제  중 에러 발생...");
			return "Error";
		}
	}
	
	@GetMapping("/detail.do")
	public String doDetail(Model model, Phone phone) {
		try {
			Phone selected =  phoneService.select(phone);
			model.addAttribute("phone",selected);
			model.addAttribute("title","핸드폰 관리 - 핸드폰 상세 조회");
			return "PhoneView";
		} catch (Exception e) {
			model.addAttribute("title","핸드폰 관리 - 에러");
			model.addAttribute("message","문제 내용 - 폰 상세 조회 중 에러 발생...");
			return "Error";
		}
	}
	/////////////////////
	@GetMapping("/login.do")
	public String getLoginForm() {
		return "redirect:Login.jsp";
	}
	
	@PostMapping("/login.do")
	public String doLogin(Model model, UserInfo user, HttpSession session) {
		try {
			UserInfo selected =phoneService.select(user);
			if(selected != null) {//찾는 회원이 있다면 
				session.setAttribute("loginUser", selected);
				return "redirect:searchPhone.do";
			}else {
				return "Login";
			}
			
		} catch (Exception e) {
			model.addAttribute("title","핸드폰 관리 - 에러");
			model.addAttribute("message","문제 내용 - 회원 로그인 중 에러 발생...");
			return "Error";
		}
	}
	
	//rest service 추가
	@GetMapping("/rest.do")
	public String getRestClient() {
		return "rest";
	}
	
}
