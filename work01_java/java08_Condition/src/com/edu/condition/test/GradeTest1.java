package com.edu.condition.test;

import java.util.Scanner;

/*
 * Scanner를 사용해서 성적과 함께 과목명을 입력 받으시오.
 * 출력 결과가 Java, A grade
 */
public class GradeTest1 {

	public static void main(String[] args) {
		//int grade = 88; //Local V
		Scanner sc = new Scanner(System.in);
		
		System.out.println("성적입력 >> ");
		int grade = sc.nextInt();
		
		System.out.println("과목입력 >> ");
		String subject = sc.next();
			
		if(grade<= 100 & grade > 80)
			System.out.println(subject+", A grade");
		else if(grade<= 80 & grade > 70)
			System.out.println(subject+", B grade" );
		else if(grade<= 70 & grade > 60)
			System.out.println(subject+", C grade");
		else
			System.out.println("try again");
	}

}
