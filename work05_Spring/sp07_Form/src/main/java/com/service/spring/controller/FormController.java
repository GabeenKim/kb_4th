package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러라고 어노테이션을 마킹하면 얘는 컴포넌트가 된다. 상속받는 형식이 아니라. 
//이런 컴포넌트를 POJO라고 한다. plain old java object :순수 자바 기법으로 만들기...?

@Controller
public class FormController {	//POJO
	
	@RequestMapping("/form.do")
	public ModelAndView form(String myName, String myAddr) {
		/*
		 * 1. 폼 값 받아서
		 * 2. 비지니스 로직 호출 
		 * 3. 반환값 바인딩
		 * 4. 네비게이션 
		 */
//		
//		String name= request.getParameter("myName");
//		String addr = request.getParameter("myAddr");
		
		return new ModelAndView("WEB-INF/views/form_result.jsp", "info", myName+"님이 사시는 곳은 "+myAddr+"입니다.");
	};

}
