package com.edu.dto;

public class Student extends User{
	private String address;

	//DB col : student_id, student_name, student_email
	public Student(int id, String name, String email, String phone,String address) {
		super(id,name, phone,email);
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return super.toString()+"address=" + address;
	}
	
	

}
