package com.edu.oop;
// NoteBook에 대한 정보를 저장하는 클래스 
public class NoteBook {

	public String brand;
	public int price;
	public int serialNumber;
	
	public NoteBook(String brand, int price, int serialNumber) {
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	
	//기본 생성자 추가... -> 오버로딩 
	public NoteBook() {}
	
	public String getNoteBookInfo() {
		return brand + "\t" 
				+ price + "\t" 
				+ serialNumber ;
	}
}
