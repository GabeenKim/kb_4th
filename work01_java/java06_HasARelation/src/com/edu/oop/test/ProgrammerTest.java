package com.edu.oop.test;

import com.edu.oop.NoteBook;
import com.edu.oop.Programmer;

public class ProgrammerTest {

	public static void main(String[] args) {
		Programmer p1 = new Programmer("James","java",200);
		
		p1.buyNoteBook(new NoteBook("Lg",100,123));
		
		System.out.print("James가 구매한 노트북 정보: ");
		System.out.println(p1.getNoteBook().getNoteBookInfo());
		
		
		System.out.print("\nJames의 메인스킬 정보 : ");
		p1.changeMainSkill("python");
		System.out.println(p1.getMainSkill());
		
		System.out.print("\nJames의 급여 정보 : ");
		p1.increamentSalary(500);
		System.out.println(p1.getSalary());
		
	}

}
