package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FrontController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 *	1. 폼 값 받아서 
		 *	2. vo 생성
		 *	3. dao 리턴 받고 비지니스 로직 호출
		 *	4. 반환값 바인딩 
		 *	5. 네비게이션 
		 *
		 *	1~4. 했다고 치고 5번만 실습
		 *	결과페이지, 페이지 이동법, 바인딩 가능한 Model & View 객체 생성해서 리턴 
		 */

		//new Model~를 통해서 뭐가 작동 되는가. 
		//1. request attribute에 message라는 이름으로 값이 바인딩 된다. 
		//2. 결과 페이지로 포워딩 된다.(디폴트가 포워딩) 
		
		//1. 단, 결과 페이지가 저장되는 물리적 위치는 알 수 없음.
		//2. 결과 페이지의 확장자를 알 수가 없음. 
		// => 따라서 우리가 지정해줘야 함. 
		return new ModelAndView("result", "message", "Hello First Spring MVC Framework");
	}
	
}
