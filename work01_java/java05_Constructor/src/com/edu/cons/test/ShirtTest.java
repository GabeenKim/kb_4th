package com.edu.cons.test;

import com.edu.cons.Shirt;

public class ShirtTest {
	public static void main(String[] args) {
		/*
		 * 객체 생성의 원리 => 걍 외워 
		 * 자바 언어는 객체를 생성할 때 new를 사용
		 * 맨 앞 class는 객체 생성 시 type으로 작용한다.
		 * new Shirt() 객체를 생성하면 
		 * "Shirt 클래스의 멤버가 메모리에 올라간다." -> 5개 (필드 3개 + 메소드 2개) 
		 *   
		 */
		Shirt s1 = new Shirt(); // ->객체 생성과 동시에 값 주입을 원하면 생성자를 이용

//		s1.setShirt("", false, 'R');
		// 필드에는 무조건 기본 값이 들어가 있다. 문자열 - null/ int - 0 / char - 한 문자만큼의 공백
		System.out.println(s1.getShirt());
	}

}
