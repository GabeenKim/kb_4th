package servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SubjectAjax")
public class SubjectAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB연결 코드 필요
			
		System.out.println("===========do get11111===========");
		String result = "JAVA | JDBC | BootStrap | Spring Framework | AI";
		
		request.setAttribute("result", result); //데이터 map방식으로 바인딩
		
		//결과 페이지 생성 
		request.getRequestDispatcher("Result.jsp").forward(request, response);
	}

}
