package com.edu.test;

/*
  Singletone pattern 
  :: 클래스로부터 오직 단 하나의 객체만 생성하도록 하는 디자인 패턴
  
  <Syntax>
  1. 일단 클래스 안에서 객체 하나는 먼저 생성 	
  	static private 객체 생성
  	
  2. 다른 클래스에서는 객체 생성 못하도록 막아둔다. 
  	private 생성자
  	
  3. 하나 생성한 객체를 여기 저기서 가져다 쓰도록 public한 기능으로 리턴받아둔다. 
  	public static Instance getInstance(){}
  	이때 반드시 stati을 써주어야지 객체 생성을 하지 않아(메모리로드X)도 이 메소드를 가져다 쓸 수 있음. 
 */
class ServiceImpl{
	static private ServiceImpl service = new ServiceImpl();
	
	private ServiceImpl() {
		System.out.println("Singletone Pattern Ready");
	}
	
	public static ServiceImpl getInstance() {
		return service;
	}
}
public class StaticExamTest5 {
	public static void main(String[] args) {
		// ServiceImpl ss = new ServiceImpl(); //private로 외부에서 생성자 생성을 막아놓아서 객체 생성 못함.
		ServiceImpl ss1 = ServiceImpl.getInstance();
		ServiceImpl ss2 = ServiceImpl.getInstance();
		ServiceImpl ss3 = ServiceImpl.getInstance();
		
		System.out.println(ss1);
		System.out.println(ss2);
		System.out.println(ss3);
		//주솟값 동일 
	}
}
