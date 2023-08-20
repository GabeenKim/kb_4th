package com.edu.test;

import java.util.Scanner;

/*
 * 실행 시점에서 실제값을 입력하기 위해서는 Scanner를 사용해야 한다. 
 * 
 * Scanner 생성하는 방법은 과연 어떻게 알 수 있을까?
 * 
 * 실행 시 값을 입력받는 방법은
 * 1. 키보드로 입력
 * 2. 파일에 값을 입력 
 * 	Scanner sc = new Scanner(System.in);  ---> 키보드로 값을 입력 받을 때 
 * 	Scanner sc = new Scanner(new Flie("input.text"));  ---> 파일로 값을 입력 받을 때 
 * 
 * System.out -> out은 필드. OutputStream(콘솔)
 * System.in -> in도 필드. InputStream(키보드)
 * 
 * nextInt() - 공백을 기준으로 값을 반환
 * 			 - Enter를 치더라도 Enter값을 없애고 해당 라인의 커서가 위치함. 
 * 			 - int에 해당하는 정수값을 받아온다. 
 * 
 */
public class ScannerTest1 {
	public static void main(String[] args) {
		//키보드로 입력되는 값을 받아오는 Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		//정수 값을 입력받는 기능...
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		//System.out.println(num1 +" " +num2);
		System.out.printf("num1 : %d, num2 : %d",num1,num2);
		
		
//		sc.nextDouble();
//		sc.next();
//		sc.nextLine();
	}

}
