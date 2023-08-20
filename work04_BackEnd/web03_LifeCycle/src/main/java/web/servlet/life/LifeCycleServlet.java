package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Life"}, loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//필드
	private int count =0;
	

    public LifeCycleServlet() {
        System.out.println("1. Servlet 인스턴스 생성... 디폴트로");
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("2. init...calling...by container");
    }
    
    @Override
    public void destroy() {
    	System.out.println("4. Servlet 인스턴스 death...");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);	
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성
		System.out.println("3. service..../doGet | doPost...by Container");
		
		//한글처리는 무조건 PrintWriter 받기 전에 작성해야 함. 
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        PrintWriter out = response.getWriter();
        
        //브라우저로 바로 출력 
        out.println("<body  bgcolor='yellow'>");
        out.println("<h3>life cycle callback method</h3>");
        out.println("<h4><b> Count :: "+ ++count +"</b></h4>");
        out.println("</body>");
        
        out.close();
        
	}

}
