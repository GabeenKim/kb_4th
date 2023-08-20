package com.edu.parent;

import com.edu.util.MyDate;

//Parent Class
public class Employee {
	private String name;
	private MyDate birthday;
	private double salary;
	
	//기본생성자 
	public Employee() {}
	public Employee(String name, MyDate birthday, double salary) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}
	
	
	
	public String getDetails() {
		return name + "-" + birthday + "-"  + salary ;
	}
	
	
}
