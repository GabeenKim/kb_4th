package com.edu.oop;
/*
 * 특정한 대상에게 
 * 인삿말을 출력하는 기능을 가진 클래스 
 * 
 * 클래스 구성요소 2개
 * 1) 변수 Member Variable :  
 * 2) 메소드 Method : 
 * 
 * 클래스를 작동시키려면? -----> 이런 일을 하는 애가 : 실행 클래스 / Test 클래스 
 * 1) 변수는 공간 -> 따라서 값을 입력 
 * 2) 메소드는 부르면 됨. -> 호출, calling 
 */

public class Greet {
	//변수 선언 : 데이터 타입 + 변수 이름 
	public String target;
	public String message;
	
	//기능정의 : 콘솔창에 무엇인가를 출력 
	public void sayHello() { // <- 메소드 선언부 
		System.out.println(target +" , " + message);	//메소드 구현부
		
	}
	
}
