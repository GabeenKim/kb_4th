package web.servlet.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Redirect2")
public class Redirect2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Redirect2Servlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 	1. 폼 값 (하나만) 입력 받는다. 
		 	2. 만약에 어느 값도 선택되지 않았다면...에러페이지로 연결 
		 		하나의 값이 선택되었다면 redirect2.jsp로 바로 이동 	
		 	3. redirect2.jsp에서는 <% %> <%= %>를 잘 사용해서 
		 		당신이 선택한 도시는 000입니다라고 출력하기.
		 */
		//한글처리
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        String value = request.getParameter("city");
        System.out.println(value);
        if( value==null) {
        	response.sendRedirect("./error/error2.html");
        }
        //else처리를 안 해주면 null이어서 에러페이지로 응답을 해주고 난뒤, forward를 하게 됨. null이 끝난 후에 else가 없으면 자동적으로 포워드를 하기떄문에 에러 발생.
        //즉 응답이 커밋된 후에는 포워드 할 수 없어서 에러 페이지로 갔다가 포워드된 페이지를 찾을 수 없어서 에러가 난 것. 
        else request.getRequestDispatcher("redirect2.jsp").forward(request, response);
//        if( value!=null) {
//
//            request.getRequestDispatcher("redirect2.jsp").forward(request, response);
//        }
//    	response.sendRedirect("./error/error2.html");
  
	}

}
