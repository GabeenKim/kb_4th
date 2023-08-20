package com.edu.dto;

public class Teacher extends User{
	private String subject;

	public Teacher() {};
	//DB col : teacher_id, teacher_name, teacher_email
	public Teacher(int id, String name,String email, String phone, String subject) {
		super(id,name, phone,email);
		this.subject = subject;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return super.toString()+"subject= " + subject;
	}
	
	
}
