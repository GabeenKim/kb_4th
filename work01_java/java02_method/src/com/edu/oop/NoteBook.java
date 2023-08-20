package com.edu.oop;

public class NoteBook {

	public String brand;
	public int price;
	public int serialNumber;
	
	public void printNoteBookInfo() {
		System.out.println("브랜드 : \t" + brand 
						+ "\n가격 : \t" + price 
						+ "원 \n시리얼 넘버 : \t" + serialNumber );
	}
	//필드에 값 할당하는 기능을 추가 == 주입(set~)
	public void setNoteBook(String brand, int price, int serialNumber) {
		//필드와 지역변수를 구분하기 위해서 this 키워드를 필드 앞에 붙인다. 
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
		
	}
}
