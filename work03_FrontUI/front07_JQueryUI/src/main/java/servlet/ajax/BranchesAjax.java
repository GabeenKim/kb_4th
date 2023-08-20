package servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BranchesAjax")
public class BranchesAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB 갔다 왔다 치고...
		
		System.out.println("==========do get2222==========");
		String result = "<ul><li>국민은행 서초 지점</li><br/>"
					+"<li>국민은행 강남 지점</li><br/>"
					+"<li>국민은행 선릉 지점</li><br/>"
					+"<li>국민은행 역삼 지점</li><br/>"
					+"<li>국민은행 강북 지점</li><br/>"
					+"<li>국민은행 가산디지털단지 지점</li><br/>"
					+"<li>국민은행 용산 지점</li></ul>";
		
		request.setAttribute("result", result); //데이터 map방식으로 바인딩
		
		//결과 페이지 생성 
		request.getRequestDispatcher("Result.jsp").forward(request, response);
	}

}
