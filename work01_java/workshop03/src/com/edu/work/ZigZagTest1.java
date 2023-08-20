package com.edu.work;
/* 
 * 정수 10진수는 %d를 이용해서 표현한다. 
 * %3d는 3()() 옆으로 2만큼의 공간 생성. 즉 정렬이 필요한 무엇인가를 출력할 때 이렇게 작성하면 편함 .
 * %03d 앞에 2개의 00이 생성 003 이렇게,,,?
 */

public class ZigZagTest1 {

	public static void main(String[] args) {
		int [][] intArray = 
			{ 
			  { 1, 2, 3, 4, 5 },
			  { 6, 7, 8, 9,10 },
			  {11,12,13,14,15 },
			  {16,17,18,19,20 },
			} ;
		

		for (int i = 0; i < intArray.length; i++) {
			if( i % 2 == 0 ) {
				for (int j = 0; j < intArray[0].length; j++) {
					System.out.printf( "%3d", intArray[i][j]);
				}
			}else {
				for (int j = intArray[0].length-1; j >= 0; j--) {
					System.out.printf( "%3d", intArray[i][j]);
				}
			}
			System.out.println();
		}
	}

}

