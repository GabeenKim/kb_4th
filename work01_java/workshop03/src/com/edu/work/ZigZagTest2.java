package com.edu.work;

public class ZigZagTest2 {

	public static void main(String[] args) {
		int [][] intArray = 
			{ 
			  { 1, 2, 3, 4, 5 },
			  { 6, 7, 8, 9,10 },
			  {11,12,13,14,15 },
			  {16,17,18,19,20 },
			} ;

		for (int i = 0; i < intArray[0].length; i++) {
			if( i % 2 == 0 ) {
				for (int j = 0; j < intArray.length; j++) {
					System.out.printf( "%3d", intArray[j][i]);
				}
			}else {
				for (int j = intArray.length-1; j >= 0; j--) {
					System.out.printf( "%3d", intArray[j][i]);
				}
			}
			System.out.println();
		}
	}

}
