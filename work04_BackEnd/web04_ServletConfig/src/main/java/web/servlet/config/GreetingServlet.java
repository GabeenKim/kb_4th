package web.servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //greet에 들어가는 값을 서비스 요청 직전에 받아야 한다. (화면의 있는 값을 받기엔 시점이 느림) 
	//어디서 받아옴? => 
	private String greet;
	
    public GreetingServlet() {
        System.out.println("1. GreetingServlet 디폴트로 생성 (즉 필드 값을 못 가짐)");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("2. GreetingServlet 필드 초기화 진행 ");
    	greet = getInitParameter("GREET");
    	System.out.println("Greet Message :: "+greet);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직 작성...클라이언트 요청 시점에 호출됨 -> 즉 폼 값을 받아오는 것. 
		
		//한글처리는 무조건 PrintWriter 받기 전에 작성해야 함. 
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		     
		System.out.println("3. doProcess 호풀... 클라이언트 요청 시 동작");
		String name = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		//greet : ready on 상태에서 받아온 값. 컨테이너 차원에서 설정한 정보. 서블릿 필드 초기화
		//name : 서비스 요청 시 받아온 값. 폼 값 받아서 화면에 출력
		out.println("<body><h3>"+name +",   " +greet+"</h3><body>"); 
		
	}

}
