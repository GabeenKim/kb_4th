package com.edu.condition2.test;

import java.util.Scanner;

public class PatternGameTest {
	public static void solv(int num ) {
		//1의 자리가 3의 배수인 경우
		int one = num % 10 ;
		int ten = num / 10 ;
		
		String result = "";
		
		if (one%3==0) result += "@";
		if (ten%3==0) result += "@";
		
		if (result == "")
			System.out.println(num);
		else 
			System.out.println(result);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("값 입력>>");
		int n = sc.nextInt();
		
		solv(n);
		
	}

}
