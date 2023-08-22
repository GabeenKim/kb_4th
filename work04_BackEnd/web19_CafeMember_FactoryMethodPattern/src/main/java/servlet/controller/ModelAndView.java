package servlet.controller;
/*
	Controller의 역할
	가장 마지막 역할이 결과 페이지...
	결과 페이지를 리턴 받으면 무조건 페이지 이동방식이 forward 방식밖에 안 됨. 
	::
	결과 페이지 이름도 String으로 저장 
	페이지 이동방식도 저장 
	위 2가지 정보가 네비게이션 과정에서 필요한 정보들이다. 
*/
public class ModelAndView {
	private String path; //결과 페이지 이름
	private boolean isRedirect;
	
	public ModelAndView() {}
	
	//forward 
	public ModelAndView(String path) {
		super();
		this.path = path;
	}
	
	//redirect : isRedirect에 true값을 주면은 인자 값 2개
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
