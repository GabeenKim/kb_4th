package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * web.xml 일종의 주문서 = @WebServlet("/LFS")
  <servlet>
 	<servlet-name> 패키지를 뺀 클래스 이름 </servlet-name>
 	<servlet-class> web.servlet.http  </servlet-class>
  </servlet>
  
  클라이언트가 부르는 이름으로 매핑 한 번 더 해야함. 
  <servlet-mapping>
  	<servlet-name> 패키지를 뺀 클래스 이름 </servlet-name>
 	<url-pattern> /LFS s</url-pattern>
  </servlet-mapping>
  
 */
//processor
@WebServlet("/LFS")
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//thread
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	//thread
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);		
	}
	
	//모든 요청의 처리를 Process에서 처리한다. 
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성
		//한글처리는 무조건 PrintWriter 받기 전에 작성해야 함. 
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		
		//1. form값을 받는다. 
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. 받은 값을 가지고 비지니스 로직을 호출
		//Member member = MemberDAOImpl.getInstance().login(id, password);
		//위 코드가 동작했다 차고... 
		
		//3. 반환 값을 다시 클라이언트로 응답
		//화면에 출력하는 기능을 가지고 있는 객체를 리턴 받고 response를 통해서 
		PrintWriter out = response.getWriter(); 
		out.println("<html><body>");
		out.println("<ul><li> ID : "+ id +"</li>");
		out.println("<li> PW : "+ password +"</li>");
		out.println("</ul></body></html>");
		
		out.close();
	}

}
