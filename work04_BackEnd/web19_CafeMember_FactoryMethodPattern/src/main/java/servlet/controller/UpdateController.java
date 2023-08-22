package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequesAndView(HttpServletRequest request, HttpServletResponse response) {
		 String path = "index.jsp"; //실패 시 경로
		 String id = request.getParameter("id");
	     String password = request.getParameter("password");
	     String name = request.getParameter("name");
	     String address = request.getParameter("address");
	     
	     MemberVO pvo = new MemberVO(id,password,name,address);
	     
        try {
      	  	MemberDAOImpl.getInstance().updateMember(pvo);
      	  	
      	  	//로그인과 수정 로직은 반드시 session에 바인딩 해야함!
      	  	HttpSession session = request.getSession();
      	  	if(session.getAttribute("vo")!=null) {		//로그인 된 상태에서만 정보 수정 가능하기 때문
      	  		session.setAttribute("vo", pvo);
      	  		path = "update_result.jsp";
      	  	}

        }catch(Exception e ) {
      	  	
        }

		return new ModelAndView(path);
	}

}
