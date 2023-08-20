package com.edu.test;

class StaticExam{
	static String name = "James"; //static V
	static int age = 44; //static V
	int ciunt =1; //field
	
	public static void getMember() {
		System.out.println("우/유/빛/깔/ "+name);
	}
	public void getMember2() {
		//static String address = "역삼동";
		
		System.out.println("우/유/빛/깔/ "+name);
	}
}

public class StaticExamTest1 {
	public static void main(String[] args) {
		//객체 생성과정 없이 바로 사용 가능 
		StaticExam.getMember();
		
		//객체를 생성 == 클래스의 getMember2가 메모리에 올라가서 사용할 수 있음. 
		StaticExam se = new StaticExam();
		se.getMember2();

	}

}
