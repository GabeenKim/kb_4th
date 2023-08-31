package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.MemberVO;
import com.service.spring.model.MemberDAO;
import com.service.spring.model.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping("find.do")
	public String find(Model model, String id) throws Exception {
	
		String path = "find_fail";
		MemberVO rvo =memberService.getMember(id);
		
		if(rvo!=null) {
			model.addAttribute("vo", rvo);
			model.addAttribute("msg","회원 발견 성공");
			path= "find_ok";
		}else {
			model.addAttribute("msg","회원 발견 실패");
			path= "find_fail";
			
		}
		return path;
	}
	@RequestMapping("showAll.do")
	public String showAll(Model model) throws Exception {
		String path ="Error";
		List<MemberVO> list =null;
		try {
			list =memberService.showAllMember();
			model.addAttribute("vo",list);
			model.addAttribute("msg","회원 불러오기 성공");
			path ="allView";
		} catch (Exception e) {
			model.addAttribute("msg","회원 불러오기 실패");
			path= "find_fail";
		}
		return path;
		
	}
	
	@RequestMapping("update.do")
	public String update(Model model, MemberVO vo )throws Exception{
		String path="";
		try {
			memberDAO.updateMember(vo);
			model.addAttribute("vo",vo);
			model.addAttribute("msg","회원 정보 수정 성공");
				
			path = "update_result";
			
		} catch (Exception e) {
			model.addAttribute("msg","회원 정보 수정 실패");
			path= "update_fail";
		}
		
		return path;
		
	}
	@RequestMapping("register.do")
	public String register(Model model, MemberVO vo )throws Exception{
		String path="";
		try {
			memberDAO.registerMember(vo);
			
			model.addAttribute("name",vo.getName());
			model.addAttribute("msg","회원  가입 성공");
			
			path = "register_result";
		} catch (Exception e) {
			model.addAttribute("msg","회원 가입 실패");
			path= "register_fail";
		}
		
		return path;
		
	}
	
	@RequestMapping("login.do")
	public String login(Model model, MemberVO vo, HttpSession session) throws Exception {
		String path ="Error";
		try {
			MemberVO rvo = memberService.login(vo);
			if(rvo!=null) {
				session.setAttribute("vo",rvo);
				
				model.addAttribute("vo",rvo);
				model.addAttribute("msg","로그인 성공");
				path ="login_result";
			}else {
				model.addAttribute("msg","로그인 실패");
				path= "..spring/login";
			}
		} catch (Exception e) {
			model.addAttribute("msg","로그인 실패");
			path= "login_fail";
		}
		return path;
		
	}
	
	@RequestMapping("logout.do")
	public String logout(Model model, HttpSession session)throws Exception {
		String path ="Error";
		
		try {
			session.invalidate();
			model.addAttribute("msg","로그아웃 성공");
			path ="logout";
		} catch (Exception e) {
			model.addAttribute("msg","로그아웃 실패");
			path= "logout_fail";
		}
		return path;
		
	}
	
	
}
