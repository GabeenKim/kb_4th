package com.edu.oop;

public class Programmer {
	//생성자 주입
	public String name;
	public String mainSkill;
	public int salary;
	
	//setter 주입
	/////has a relation/////
	public NoteBook noteBook ;

	public Programmer(String name, String mainSkill, int salary) {
		this.name = name;
		this.mainSkill = mainSkill;
		this.salary = salary;
	}
	
	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	
	public NoteBook getNoteBook() {
		return noteBook;
	}

	//메인 주입의 통로를 생성자로 했는데 왜 또 오버라이트 하는것? => 주력기술이 바뀔 수 있으니까.
	//즉 변경이 일어났을 때 set == change 따라서 change~로 메소드 명을 변경해라. 
	public void changeMainSkill(String mainSkill) {
		this.mainSkill = mainSkill;
	}
	
	public String getMainSkill() {
		return mainSkill;
	}
	
	//기능추가...
	public int annualSalary() {
		return salary * 12;
	}
	
	public void increamentSalary(int amt) {
		salary += amt;
		
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
}
