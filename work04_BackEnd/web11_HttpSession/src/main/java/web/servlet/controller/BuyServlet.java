package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BuyServlet() {
        
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
      
      //새로운 세션이 아니라 이전 세션일 것. 
      HttpSession session = request.getSession();
      
      //이 조건을 꼭 넣어줘야 함. 뜻은 로그인 되어 있는 상태라면...
      if(session.getAttribute("vo") != null) {
    	  System.out.println("JSESSIONID BuyServlet ::"+ session.getId());
    	  session.setAttribute("book", "오펜하이머"); //원래는 객체 주입 
    	  request.getRequestDispatcher("buy_result.jsp").forward(request, response);
    	  
      }else {  	// 로그인 안 된 상태라는 뜻. 따라서 다시 로그인하러 보내야 함. 
    	  response.sendRedirect("login.html"); //정적인 문서는 리다이렉트 해야함.
      }

    }

}
