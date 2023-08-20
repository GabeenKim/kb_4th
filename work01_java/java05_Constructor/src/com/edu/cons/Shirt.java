package com.edu.cons;

public class Shirt {
	public String brand;
	public boolean longSleeved;
	public char color;
	
	//값 주입 지역변수와 필드를 구분하기 위해 필드 앞에 this.
	public void setShirt(String brand,boolean longSleeved,char color) {
		//필드 초기화
		this.brand = brand;
		this.longSleeved = longSleeved;
		this.color = color;
	}
	
	//값 반환 
	public String getShirt() {
		return brand +", "+ longSleeved +", "+ color;
	}
}
