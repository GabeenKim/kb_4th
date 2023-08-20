package com.edu.child;

import com.edu.parent.Parent;

//자식 클래스 
public class Child extends Parent {
	public void test() {
		//부모 클래스(다른 패키지, 디렉토리에 들어있는)의 필드에 접근 
		System.out.println(publicVar);
		System.out.println(protectedVar); //상속관계에서는 public처럼 쓰인다.
		
		//not visible 
//		System.out.println(var); //다른 디렉토리
//		System.out.println(privateVar); //다른 클래스 
	}
}
