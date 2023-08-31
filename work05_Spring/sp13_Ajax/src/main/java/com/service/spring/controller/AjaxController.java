package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Person;

@Controller
public class AjaxController {
	
	//Service wired 됐다 치고...
	
	@RequestMapping("/") //http://127.0.0.1:8888/spring -> redirect로 결과페이지 반환
	public String index() {
		System.out.println("context path calling...");
		return "redirect:index.jsp";
	}
	@RequestMapping("synchro") //http://127.0.0.1:8888/spring -> redirect로 결과페이지 반환
	public String synchro(Model model) {
		System.out.println("synchro request...");
		//ServletRequest에 자동 바인딩.... 자동으로 forward 방식으로 이동한다...
		model.addAttribute("info", "와 동기통신이다~~~!!");
		return "synchro_result";
	}
	
	@RequestMapping("asynchro")
	public String asynchro(Model model) {
		System.out.println("asynchro request...");
		//ServletRequest에 자동 바인딩.... 자동으로 forward 방식으로 이동한다...
		model.addAttribute("person", new Person("김국민","역삼동"));
		return "JsonView"; //여기선 InternalResourceViewResolver 방식이 안 통한다.
	}
	
}
