package com.edu.condition2.test;

import java.util.Scanner;

/*
 * 간단한 알고리즘을 푸는 테스트 코드의 구조 
 */
public class CatchAMouseTest {

	
	public static String solv(int x,int y, int z) {
		int xDist = Math.abs(x-z); 
		int yDist = Math.abs(y-z);
		
		if (xDist>yDist)
			return "CatB Catch!";
		else if(xDist<yDist)
			return "CatA Catch!";
		else return "Mouse Escape";

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouse = sc.nextInt();
		
		//메소드 안에서 알고리즘을 해결할 것. 
		String result = solv(catA,catB,mouse);
		System.out.println(result);
		
		
		
	}
}
