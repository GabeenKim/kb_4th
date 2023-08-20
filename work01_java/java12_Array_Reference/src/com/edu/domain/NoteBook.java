package com.edu.domain;
/*
 * 
 */

public class NoteBook {

	public String brand;
	public int price;
	public int serialNumber;
	
	public NoteBook(String brand, int price, int serialNumber) {
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	
	public NoteBook() {}
	

	@Override
	public String toString() {
	return brand + "\t" 
			+ price + "\t" 
			+ serialNumber ;
	}
}
