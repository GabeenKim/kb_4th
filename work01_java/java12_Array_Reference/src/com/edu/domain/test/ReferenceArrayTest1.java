package com.edu.domain.test;
/*garbage collection
 * Class DataType의 배열을 생성, 초기화... 
 * Memory allocation... 
 */

import com.edu.domain.NoteBook;

public class ReferenceArrayTest1 {

	public static void main(String[] args) {
		//1. 배열 생성 
		NoteBook[] notebooks = new NoteBook[3];
		
		System.out.println("============1==========");
		
		for(NoteBook nb : notebooks) {
			System.out.println(nb);
		}
		System.out.println("============2===========");
		
		notebooks[0] = new NoteBook("HP",170,123);
		notebooks[2] = new NoteBook("LG",180,456);
		
		for(NoteBook nb : notebooks) {
			if (nb== null ) continue;
			System.out.println(nb);
		}
		
		System.out.println("===========3============");
		
		for(NoteBook nb : notebooks) {
			if (nb== null ) continue;
			System.out.println(nb);
		}
	}

}
