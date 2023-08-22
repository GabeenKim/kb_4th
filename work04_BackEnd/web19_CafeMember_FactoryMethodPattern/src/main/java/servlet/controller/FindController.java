package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller {

	@Override
	public ModelAndView handleRequesAndView(HttpServletRequest request, HttpServletResponse response) {
		String id  =  request.getParameter("id");
        String path = "find_fail.jsp";
        
        //2.DAO의 로직을 이용해서 DB에서 값을 찾아온다. -> DAO 호출해서 비지니스 로직 호출
        MemberVO rvo;
		try {
			rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			
			//3.리턴 값이 있으므로 찾아온 값을 setAttribute로 바인딩 하고
	        if(rvo != null) {
	        	request.setAttribute("vo", rvo);
	        	path = "find_ok.jsp";
	        }
	        
		} catch (SQLException e) {
			
		}
		
		return new ModelAndView(path);
	}

}
