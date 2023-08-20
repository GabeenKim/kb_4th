package com.edu.test;

import java.util.Scanner;

/*
 * Test3의 문제점 해결
 * -> nextLine()을 사용한채로...
 */

public class ScannerTest4 {
	public static void main(String[] args) {
		//키보드로 입력되는 값을 받아오는 Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		//정수 값을 입력받는 기능...
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		//String name = sc.next();
		
		//라인을 바꾸는 기술 
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.println(num1 +" " +num2);
		//System.out.printf("num1 : %d, num2 : %d",num1,num2);
		System.out.println("name : " +name);
		
		
		
	}

}

