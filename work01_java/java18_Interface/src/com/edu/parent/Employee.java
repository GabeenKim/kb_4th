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
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return name + "-" + birthday + "-"  + salary ;
	}
}
