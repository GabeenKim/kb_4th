package com.self.vo;

import com.self.util.MyDate;

public class Employee {
	private String name;
	private MyDate birthDate;
	private double salary;
	
	//기본생성자
	public Employee() {}

	public Employee(String name, MyDate birthDate, double salary) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}

	
	public String getName() {
		return name;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}


	public double getSalary() {
		return salary;
	}

	//salary 이므로 change가 더 적합
	public void changeSalary(double salary) {
		this.salary = salary;
	}

	//부모toString
	@Override
	public String toString() {
		return "name=" + name + ", birthDate=" + birthDate + ", salary=" + salary ;
	} 
	
	
}
