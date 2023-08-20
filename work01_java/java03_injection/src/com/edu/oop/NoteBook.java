package com.edu.oop;
// NoteBook에 대한 정보를 저장하는 클래스 
public class NoteBook {

	public String brand;
	public int price;
	public int serialNumber;
	
	//필드에 값 주입(값 할당) == 필드 초기화 /주입(set~)
	public void setNoteBook(String brand, int price, int serialNumber) {
		//필드와 지역변수를 구분하기 위해서 this 키워드를 필드 앞에 붙인다. 
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	//메소드는 반환값을 가짐. 
	//return type이 void면 반환값이 없다는 의미. 
	//즉, 반환값을 있게 만들어줘야함. -> String으로 지정 
	//client 즉 ~Test클래스로 반환해줘야함. 거기서 출력 
	public String getNoteBookInfo() {
		return brand + "\t" 
				+ price + "\t" 
				+ serialNumber ;
	}
}
