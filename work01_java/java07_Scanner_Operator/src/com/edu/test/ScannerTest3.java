package com.edu.test;

import java.util.Scanner;

/*
 * nextInt() - 공백을 기준으로 값을 반환
 * 			 - Enter를 치더라도 Enter값을 없애고 해당 라인의 커서가 위치함. 
 * 			 - int에 해당하는 정수값을 받아온다. 
 *
 * next()	- 공백을 기준으로 값을 반환 
 * 		    - Enter를 치더라도 엔터 값을 없애고 해당 라인의 커서가 위치한다. 
 * 			- 문자열에 해당하는 String 값을 받아온다. 
 * 
 * nextLine() - 공백 기준이 아닌 라인을 기준으로 데이터 반환 
 * 			  - 커서의 위치가 해당 라인이 아닌 다음 라인데 위치. 개행해버림 
 * 			  - 문자열에 해당하는 String 값을 받아온다. 
 */

public class ScannerTest3 {
	public static void main(String[] args) {
		//키보드로 입력되는 값을 받아오는 Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		//정수 값을 입력받는 기능...
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		//String name = sc.next();
		String name = sc.nextLine();
		
		//System.out.println(num1 +" " +num2);
		System.out.printf("num1 : %d, num2 : %d",num1,num2);
		System.out.printf("name : %s",name);
		
		
		
	}

}