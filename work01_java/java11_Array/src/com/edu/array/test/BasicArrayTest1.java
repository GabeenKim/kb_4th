package com.edu.array.test;
/*
 * Same DataType의 서로 다른 값들을 하나로 묶을 수 있는데 이게 바로 Array라는 객체다. 
 * 
 * Array는 
 * 	1) 선언
 * 	2) 생성
 * 	3) 초기화 
 */
public class BasicArrayTest1 {
	public static void main(String[] args) {
		
		//1.선언
		int[] arr; //dataType + 변수명;
		
		//2.생성 *(이때 size를 반드시 명시, 배열은 객체이기 때문에 new라는 키워드가 필요)
		arr = new int[3];
		
		//3.초기화
		arr[0]=11; arr[1]=1; arr[2]= 34;
		
		//출력
		for(int i=0; i<3;i++) {
			System.out.println(arr[i]);
		}
		
		

	}

}
