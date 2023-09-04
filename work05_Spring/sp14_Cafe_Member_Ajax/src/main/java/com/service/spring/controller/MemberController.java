package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
			//HttpServletRequest에 데이터 바인딩 | 페이지 이동은 forward가 기본을 작동한다.
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
			
			//return redirect:/showAll.do -> 요청으로 다시 리다이렉트
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
				    return "redirect:/index.jsp";
				}
		} catch (Exception e) {
			model.addAttribute("msg","로그인 실패");
			path= "login_fail";
		}
		return path;
		
	}
	

//	@RequestMapping("login.do")
//    public String login(HttpServletRequest request,MemberVO pvo) throws Exception{
//
//        MemberVO rvo=memberService.login(pvo);
//        if(rvo!=null) {
//            request.getSession().setAttribute("vo", rvo);
//            return "login_result";
//        }else {
//            return "redirect:/index.jsp";
//        }
//    }
//	  @RequestMapping("register.do")
//	    public String register(MemberVO pvo) throws Exception {
//	        memberDAO.registerMember(pvo);
//	        return "redirect:/showAll.do";
//	    }
//
//		@RequestMapping("update.do")
//	    public String update(HttpSession session, MemberVO pvo) throws Exception{
//	        memberDAO.updateMember(pvo);
//	        //로그인된 상태에서만 수정 가능...
//
//	        if(session.getAttribute("vo")!=null) {//로그인 상태라면
//	          session.setAttribute("vo", pvo);
//	          return "update_result";
//	        }
//	        return null;
//	    }
//		
//	    @RequestMapping("showAll.do")
//	    public String showAll(Model model )throws Exception {
//	        List<MemberVO> list=memberService.showAllMember();
//	        //HttpServletRequest에 데이타 바인딩 | 페이지 이동은 forward가 기본을 작동한다.
//	        model.addAttribute("list", list);
//
//	        return "allView";
//	    }
//	    
//	    @RequestMapping("logout.do")
//	    public String logout(HttpServletRequest request) throws Exception{
//	        HttpSession session=request.getSession();
//	        if(session.getAttribute("vo")!=null) { //로그인된 상태라면 로그아웃
//	            session.invalidate();//세션을 죽이고
//	            return "logout";
//	        }
//	        return null;
//	    }
/////////////////////////////////////
	
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
	
	@RequestMapping("idExist.do")
	public String idExist(String id, Model model) throws Exception{
		boolean check = false;
		System.out.println(id);
		String rid = memberDAO.idExist(id);
		System.out.println(rid);
		if(rid!=null) check = true;
		
		model.addAttribute("check",check);
		return "JsonView";
	}
	
}
