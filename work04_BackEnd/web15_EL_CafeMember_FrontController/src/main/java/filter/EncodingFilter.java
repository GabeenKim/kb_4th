package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//공통적으로 처리해야할 로직... 모든 서블릿에서 
		//한글처리
		request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
		
    	//서버 상에서 다음 컴포넌트 프로그램에 연쇄적으로 필터링한 공통 로직이 적용된다.
    	//이 부분이 빠지면 공통로직을 필터링에 정의만 한 것이기에 실직적으로 처리되지 않는다.
    	chain.doFilter(request, response);
	}
	
}
