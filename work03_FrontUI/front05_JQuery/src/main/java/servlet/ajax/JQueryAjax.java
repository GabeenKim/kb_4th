package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JQueryAjax")
public class JQueryAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id라는 키에 매핑된 값 저장
		String id = request.getParameter("id");
		
		
		//클라이언트로 응답하기 전, 시간을 고의적으로 지연시킨다.  
//		try {
//			Thread.sleep(1000); //1초 동안 프로그램을 멈춘다. 응답도 1초 느려짐. 
//		}catch(InterruptedException e){
//			
//		}
		
		
		//이 값을 가지고 DB 갔다왔다 치고 ... 로직이 돌아갔다 피고.... 
		//응답을 할 때 출력할 객체
		PrintWriter out = response.getWriter();
		out.print(id);
	
	}

}
