package com.edu.test;
import java.util.Scanner;

/*
 <<입력 Data Sample >>
 6
 1 4 4 4 5 3
 
 */
public class PersonTypeTest {
	
	public static int solv(int[] arr) {
		int[] type = new int[6];
		int maxNum = 0;
		int maxIdx = 0;
		
		for(int i=0; i<arr.length;i++) {
			int idx = arr[i];
			type[idx] += 1;
		}
		
		for(int i=1; i<type.length;i++) {
			if (type[i]>maxNum) {
				maxNum = type[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sample Data Input >>> ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 코드 구현 
		int answer = solv(arr);  
		System.out.println("가장 많은 타입의 유형은 "+ answer+" 타입입니다.!!");
		  
		 }
		}

