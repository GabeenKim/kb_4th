package com.edu.oop.test;

import com.edu.oop.NoteBook;

public class NoteBookTest {

	public static void main(String[] args) {
		/*
		 1. 객체 생성 == 클래스의 멤버를 메모리에 올린다. 
		 2. 멤버의 접근 
		  		필드 : 값 할당
		  		메소드 : 호출 
		 */
		
		NoteBook nb1 = new NoteBook("LG",170,12);
		nb1.brand = "HP";
		System.out.println(nb1.getNoteBookInfo());
		
		NoteBook nb2  = new NoteBook();
		
		
	}

}
