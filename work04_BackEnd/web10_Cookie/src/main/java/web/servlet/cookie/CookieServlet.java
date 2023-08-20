package web.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CookieServlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
	      response.setContentType("text/html;charset=utf-8");
	      
	      //1. 쿠키 생성
	      Cookie c1 = new Cookie("id","kblife");
	      Cookie c2 = new Cookie("today","2023-08-18");
	      
	      //쿠키 만료 기간 지정
	      c1.setMaxAge(24*60*60); 	//하루동안 정보 보관 
	      c2.setMaxAge(24*60*60*2);			//이틀동안 정보 보관
	      
	      //2. 생성된 쿠키를 클라이언트로 보냄...그러면 브라우저에 저장 됨. 
	      response.addCookie(c1);
	      response.addCookie(c2);
	      
	      //3.페이지 이동 
	      response.sendRedirect("getCookie.jsp");
	      
	}


}
