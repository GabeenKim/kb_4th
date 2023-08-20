package com.edu.oop.test;
/*
 * ~Test 클래스가 하는 일 
 * 1) 변수에는 값을 입력
 * 2) 메소드는 호출 
 */
import com.edu.oop.Greet;

public class GreetAppTest {

	public static void main(String[] args) {
		Greet g = new Greet();
		
		// 변수 초기화 (Initialization)
		g.target = "kb it's life 4기";
		g.message = "hello java~~!!";
		
		// 메소드 호출 
		g.sayHello();
		
	}

}
