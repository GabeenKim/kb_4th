package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FrontController() {
       
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	request.setCharacterEncoding("utf-8");
//    	response.setContentType("text/html;charset=utf-8");
    	
    	//로직은 여기서 작성...어떤 요청이 들어왔는지를 ... 구분
    	String command = request.getParameter("command");
    	//register, login, find, showAll...
    	String path ="index.html"; 
    	
    	if(command.equals("register")) { //회원 가입 로직 
    		path = register(request,response);
    		
    	}else if(command.equals("find")) {
    		path = find(request,response);
    	}else if(command.equals("login")) {
    		path = login(request,response);
    	}else if(command.equals("showAll")) {
    		path = showAll(request,response);
    	}
    	
    	
    	request.getRequestDispatcher(path).forward(request, response);
    }//doProcess
    
    private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        
        MemberVO pvo = new MemberVO(id,password,name,address);
        String path = "index.html"; //실패 시 경로
        try {
      	  MemberDAOImpl.getInstance().registerMember(pvo);
      	  path = "register_result.jsp"; //성공 시 경로
      	  
        }catch(Exception e ) {
      	  
        }

        return path;
    }
    
    private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		return path;
    }
    
    private String login(HttpServletRequest request, HttpServletResponse response) {
    	String id = request.getParameter("id");
        String password = request.getParameter("password");
        
        String path = "index.html";
  		
  		try {
  			MemberVO rvo=MemberDAOImpl.getInstance().login(id, password);
  			HttpSession session = request.getSession();
  			
  			if(rvo!=null) {
  				session.setAttribute("vo", rvo);
  				System.out.println("JSESSIONID :: "+session.getId());
  				path = "login_result.jsp";
  			}
  		}catch(Exception e) {
  				path = "login.jsp";
  		}
    	return path;
    }
    
    private String showAll(HttpServletRequest request, HttpServletResponse response) {
    	String path = "index.html";
    	 try {
    			ArrayList<MemberVO> list =  MemberDAOImpl.getInstance().showAllMember();
    			request.setAttribute("list", list);
    			path = "allView.jsp";
    		} catch(Exception e) {

    	    }
    	return path;
    }
    
}
