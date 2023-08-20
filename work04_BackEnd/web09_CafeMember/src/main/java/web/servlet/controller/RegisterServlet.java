package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.membership.MemberImpl;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
       
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
	}
	
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response);
  }

  protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      
      //1. 폼 값 받아서 
      //2 VO 생성...PVO
      //3. DAO 리턴 받고 비지니스로직 호출
      //4. 리턴되는 값이 없으니 바인딩 할 필요 X
      //5. 네비게이션
      
      String id = request.getParameter("id");
      String password = request.getParameter("password");
      String name = request.getParameter("name");
      String address = request.getParameter("address");
      
      MemberVO pvo = new MemberVO(id,password,name,address);
      String path = "index.html";
      try {
    	  MemberDAOImpl.getInstance().registerMember(pvo);
    	  //path = "register_result.jsp";
//    	  path = "allView.jsp";
    	  
      }catch(Exception e ) {
    	  
      }
//      request.getRequestDispatcher(path).forward(request, response);
      //서블릿으로 다시 재요청해야 함
      response.sendRedirect("AllMember");
  }

}
