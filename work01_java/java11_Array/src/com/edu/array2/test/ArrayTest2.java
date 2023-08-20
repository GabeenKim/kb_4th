package com.edu.array2.test;

/*
 * 배열은 resizing이 안된다. 
 * 즉, 사이즈를 추후에 늘리고 싶다고 막 늘릴 수 없음. 
 * 
 */
public class ArrayTest2 {
	public static void main(String[] args) {
		int[] member = {1,2,3,4,5};
		
		//사이즈를 늘리려고 하는 순간 생성이 또 일어나서 객체가 하나 더 생기고 그것을 참조하게 됨. 
		member = new int[8];
		
		member[5]=6;
		member[6]=7;
		member[7]=8;
		
		//0,0,0,0,0,6,7,8
		for(int v:member) System.out.println(v);
				
	}
}
