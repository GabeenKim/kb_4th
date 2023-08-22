package web.controller;

public class FindController implements Controller{

	@Override
	public String handleRequest() {
		/*
		 *	Controller의 역할 
			1. 폼 값 받아서 
			2. vo 생성 
			3. DAO리턴 받기
			4. 비지니스 로직 호출
			5. 네비게이션 
			=> MVC 패턴에서는 위 역할을 서블릿마다 해당 코드가 작성됨. 
			=> FrontController 패턴에서는 메소드 단위에서 작성됨.
			=> Factory 패턴에서는 인터페이스 상속 받은 자바 클래스에서 작성됨. 
			 					=> 컴포넌트 : 인터페이스 상속 받아서 재 사용성이 높아진 자바 클래스. 
			 					
		*/
		System.out.println("Find Controller...Find Member");
		//리턴 : 결과 페이지 이름을 리턴
		return "find_ok.jsp";
	}
	
}
