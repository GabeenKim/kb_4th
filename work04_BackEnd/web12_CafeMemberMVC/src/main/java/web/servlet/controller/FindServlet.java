package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


@WebServlet("/Find")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindServlet() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        //로직은 여기서 작성 
        //1.화면의 폼 값을 읽어온다. 
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
		//4.find.jsp로 페이지 이동 - forward?
        request.getRequestDispatcher(path).forward(request, response);
        
	}

}
