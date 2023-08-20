package web.servlet.contoroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.dto.Member;

@WebServlet("/find")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 처리
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        //컨트롤러(서블릿)의 역할. 
        //1. 폼 값 받아오기 
        //2. DAO리턴 받고 ... *비지니스 로직* 호출  => 제일 중요한 역할. 
        //3. DB리턴된 값 반환 
        //4. 반환값을 Attribute에 바인딩
        //5. 페이지 이동 
        
        String address = request.getParameter("address");
        
        //MemberDAO.getInstanceOf().findMemeberByAddress(address); //값 받았다 치고
        Member mem1 = new Member("아이유","여의도",33);
        //Member mem2 = new Member("박재범","여의도",35);
	
        //ArrayList<Member> members = new ArrayList<>();
        
        //members.add(mem1);
        //members.add(mem2);
        //여기까지 DB 갔다가 반환된 리스트 객체라고 생각하기 
        
        //컨벤션 : 바인딩하는 객체랑 key값 이름이 동일해야함. 
        request.setAttribute("mem1", mem1); 
        
        //이동할 페이지 이름 적고 forward()를 만나면 페이지가 직접 이동 ...
        //인자값이 존재하는데, 포워드가 현재 모든 권한을 가지고 이동한다. 
        request.getRequestDispatcher("result.jsp").forward(request, response); 
        
        //포워드 안 하고 jsp로 리다이렉트한 경우 
        //PrintWriter out = response.getWriter();
        //out.println("<h3>Result Page</h3>");
        //out.println("<h4><a href=result.jsp>여기를 클릭하면 JSP 연결됩니다..</a></4>");
	}

}
