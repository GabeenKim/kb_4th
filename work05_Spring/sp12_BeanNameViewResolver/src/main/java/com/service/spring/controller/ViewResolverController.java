package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ViewResolverController {

	//Service wired 했다고 치고..
	@RequestMapping("findBoard.do")
	public String findBoard() {
		System.out.println("service call...데이터 리턴...바인딩...");
		return "board_result";
		
	}
	
	@RequestMapping("findProduct.do")
	public String findProduct() {
		System.out.println("service call...데이터 리턴...바인딩...");
		return "poduct_result";
		
	}
	
	@RequestMapping("register.do")
	public String register() {
		System.out.println("service call...데이터 리턴...바인딩...");
		return "register_result";
		
	}
}
