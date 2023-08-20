package com.edu.test;

class Person{
	String name;
	public Person(String name) {
		super();
		this.name = name;
	}
}

public class StaticExamTest4 {
	static int counter;
	public static void main(String[] args) {
		Person p = new Person("JAMES");
		System.out.println("James Person creating...Person Instance Initialization...");
		
	}
	//static initialization block 
	static {
		counter++;
		System.out.println("static initailization block..."+ counter);
	}
}
