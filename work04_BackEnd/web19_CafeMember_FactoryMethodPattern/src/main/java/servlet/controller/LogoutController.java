package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequesAndView(HttpServletRequest request, HttpServletResponse response) {
        String path = "index.jsp";
  		
  		try {
	  		//세션을 죽이는 로직...invalidate()
  			HttpSession session = request.getSession();
  			if(session.getAttribute("vo") != null) { //로그인 된 상태...
  				session.invalidate();//로그아웃 로직
  				path = "logout.jsp";
  			}
  			
  		}catch(Exception e) {
  				path = "login.jsp";
  		}
		
		return new ModelAndView(path);
	}

}
