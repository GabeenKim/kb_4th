package com.edu.oop.test;

import com.edu.oop.NoteBook;
/*
 * 문제점
 * 필드에 일일이 값 초기화하고 있음. 
 * 필드의 갯수가 늘어나면 코드라인도 증가. 가독력 저하. 
 * 
 * 해결책
 * 필드 초기화 하는 기능을 추가한다. 
 * 
 */
public class NoteBookTest {

	public static void main(String[] args) {
		//객체 생성 
		NoteBook nb = new NoteBook();
		
		nb.brand = "samsung";
		nb.price = 500000 ;
		nb.serialNumber = 12345678;
		
		nb.printNoteBookInfo();
	}

}
