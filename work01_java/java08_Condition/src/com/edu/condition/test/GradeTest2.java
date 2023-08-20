package com.edu.condition.test;

import java.util.Scanner;

/*
 * 필드와 지역변수의 구분
 * -> 변수가 선언된 위치에 따라 달라진다. 
 * 
 * field - 클래스 바로 아래, 메소드 블록 바깥
 * 		 - 기본값을 가진다. 초기화 안하고 사용해도 에러가 나지 않는다! 
 * 
 * local 변수 - 메소드 블록 안에 	
 * 			 - 기본값을 가지지 않기에 선언과 초기화가 꼭 필요하다! 안 하면 에러남. 
 * 
 */
public class GradeTest2 {

	public static void main(String[] args) {
		//int grade = 88; //Local V
		Scanner sc = new Scanner(System.in);
		System.out.println("성적입력 >> ");
		int grade = sc.nextInt();
			
		if(grade<= 100 & grade > 80)
			System.out.println("A");
		else if(grade<= 80 & grade > 70)
			System.out.println("B");
		else if(grade<= 70 & grade > 60)
			System.out.println("C");
		else
			System.out.println("try again");
	}

}
