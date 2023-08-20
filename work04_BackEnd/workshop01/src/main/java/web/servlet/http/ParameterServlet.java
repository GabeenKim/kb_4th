package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/params"}, loadOnStartup = 1)
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParameterServlet() {
    	System.out.println("1. 생성자 호출...");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("2. init 호출...");
    }
    
    @Override
    public void destroy() {
    	System.out.println("4. destroy 호출...");
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. doGet 호출...");
		//한글처리
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

		//get
        String job = request.getParameter("job");
        String pageNo = request.getParameter("pageNo");
        String searchWord =request.getParameter("searchWord");      
        
        PrintWriter out = response.getWriter();
        
        out.println("<body><h2>Job : "+job +"</h2><br>");
        out.println("<h2>PageNo : "+ pageNo +"</h2><br>");
        out.println("<h2>SearchWord : "+searchWord +"</h2></body>");
        
        out.close();
        
//	    //getWriter()를 한 번만 사용하는 방법
//		System.out.println("job : " + job);
//		System.out.println("pageNo : " + pageNo);
//		System.out.println("searchWord : " + word);
//		
//		// 브라우저에 보내기
//		// use StringBuilder
//		StringBuilder sb = new StringBuilder();
//		sb.append("<h2>job : ").append(job).append("</h2>");
//		sb.append("<h2>pageNo : ").append(pageNo).append("</h2>");
//		sb.append("<h2>searchWord : ").append(word).append("</h2>");
//				
//		response.getWriter().append(sb);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. doPost 호출...");
		//한글처리
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        //post
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        
        String[] hobby = request.getParameterValues("hobby");
        String favorite = request.getParameter("favorite");
        String desc = request.getParameter("desc");
        
        System.out.println(name +"\n"+email+"\n"+gender);
        for(String hob : hobby) {
        	System.out.print(hob+", ");
        }
        System.out.println();
        System.out.println(favorite+"\n"+desc);
        
        PrintWriter out = response.getWriter();
        
        out.println("<body><h2>name : "+name +"</h2>");
        out.println("<h2>email : "+ email +"</h2>");
        out.println("<h2>gender : "+ gender +"</h2>");
        
        out.print("<h2>hobby : ");
        for(int i=0; i<hobby.length;i++) {
        	if(i==hobby.length-1) {
        		out.print(hobby[i]);
        		break;
        	}
        	out.print(hobby[i]+", ");
        }
        
        //StringBuilder를 이용해서 getWriter를 한 번만 사용. 
//        StringBuilder sbHobby = new StringBuilder();
//      for (String h : hobby) {
// 			sbHobby.append(h).append(", ");
// 		}
// 		sbHobby.setLength(sbHobby.length()-2);
        
        out.println("</h2>");
       
        out.println("<h2>favorite : "+ favorite +"</h2>");
        out.println("<h2>desc : "+desc +"</h2></body>");
        
        out.close();
	}



}
