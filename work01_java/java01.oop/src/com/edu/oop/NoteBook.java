package com.edu.oop;

public class NoteBook {

	public String brand;
	public int price;
	public String serialNumber;
	
	public void printNoteBookInfo() {
		System.out.println("브랜드 : \t" + brand 
						+ "\n가격 : \t" + price 
						+ "원 \n시리얼 넘버 : \t" + serialNumber );
	}
	
	
}
