package com.edu.oop.test;

import com.edu.oop.NoteBook;

public class NoteBookTest {

	public static void main(String[] args) {
		//객체 생성 
		NoteBook nb = new NoteBook();
		
		nb.brand = "samsung";
		nb.price = 500000 ;
		nb.serialNumber = "SS12345678";
		
		nb.printNoteBookInfo();
	}

}
