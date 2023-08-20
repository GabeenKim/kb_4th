package com.edu.array2.test;

/*
 * 배열의 특징
 * 1. 여러개의 값을 하나로 묶는 객체...Same DataType이 전제다. 
 * 2. 배열은 사이즈를 변경할 수 없다. (Resizing 불가) 
 * 		-> 많이 잡아놓고 시작함. 
 * 3. size가 다른 배열의 element 값을 copy 해올 수는 있다.  
 * 4. 배열은 클래스타입이 존재하지 않는 객체이다. 
 */

class Person {
	String name;
	int age;
	
}
public class ArrayTest3 {

	public static void main(String[] args) {
		int[] target = {1,2,3,4,5,6}; 			//size : 6
		int[] source = {10,9,8,7,6,5,4,3,2,1};	//size : 10

		//사이즈가 다른 배열 source의 내용을 copy해서 target 값을 변경
		//변경된 값이 8,7,6,5,4,3이 되도록 하자. System.arraycopy() 이용
		//arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
		
		System.arraycopy(source,2,target, 0, target.length);
		
		for(int v:target) System.out.print(v+" ");
		System.out.println("========================");
		
		Person p = new Person();
		System.out.println("p :"+p);
		System.out.println(target);
	}

}
