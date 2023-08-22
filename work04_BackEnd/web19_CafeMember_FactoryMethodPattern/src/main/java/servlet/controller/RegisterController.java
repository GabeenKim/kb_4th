package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handleRequesAndView(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        
        MemberVO pvo = new MemberVO(id,password,name,address);
        String path = "index.jsp"; //실패 시 경로
        try {
      	  MemberDAOImpl.getInstance().registerMember(pvo);
      	  //redirect : 다시 요청
      	  path = "front.do?command=showAll";//성공 시 경로
      	  
        }catch(Exception e ) {
      	  
        }

		return new ModelAndView(path,true);
	}

}
