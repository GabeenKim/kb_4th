package web.servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
  MyGenericServlet이라는 서블릿 클래스는 자바 기반으로 만들어진 클래스 
  자바 클래스 --- JVM에서 실행 (platform)
  서블릿 --- Container(WAS, Engine)
 */
public class MyGenericServlet extends GenericServlet{

	//서비스=쓰레드 
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//웹 브라우저로 응답을 하기 위한 객체...
		PrintWriter out =response.getWriter();
		out.println("<html><body><h2>");
		out.println("hello Generic Servlet~~~");
		out.println("</h2></body></html>");
		
		out.close();
	}//클라이언트 응답이 끝남.  == thread request, response 객체는 메모리에서 내려온다.
	
}
