package com.edu.capsulation.test;

import java.util.Scanner;

import com.edu.capsulation.MyDate;
/*
 * 스캐너 사용해서 값 받아오고 0이 출력되지 않게 하라. 
 */
public class MyDateTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MyDate md = new MyDate(); //기본생성자 call 
		/*
		 * 다른 클래스에서(~Test) field에 직접적으로 접근을 못하게 해야함. 
		 * invalid한 값이 field에 저장되지 못하게 막아야 한다. 
		 */
		//The field MyDate.month is not visible : 있는데 안 보임. 즉 메모리에는 있는데 접근이 안 된다는 말. 
		//md.month = 33;
		//md.day = 33; //-> invalid한 값 
		
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		md.setMonth(month);
		md.setDay(day);

//		if(md.getMonth()==0)
//			System.out.println("invalid month");
//		else if(md.getDay()==0)
//			System.out.println("invalid day");
//		else if (md.getMonth()==0 && md.getDay()==0)
//			System.out.println("invalid date");
//		else 
		System.out.println(md.getMonth()+"월 "+md.getDay()+"일");
	}

}
