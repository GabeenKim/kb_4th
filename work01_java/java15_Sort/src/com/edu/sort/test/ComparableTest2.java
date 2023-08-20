package com.edu.sort.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Person implements Comparable<Person>{
	int age;
	String name;
	
	public Person() {}
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	//여기에 정렬 알고리즘을 넣으면 된다.
	/*
	 * 왜 리턴타입이 int?
	 * :: 
	 * 나이가 작으면 -1 
	 * 나이가 더 많으면 1
	 * 같으면 0 
	 */
	@Override
	public int compareTo(Person per) {
		//내림차순 정렬하고 싶으면 -1과 1을 바꾸면 됨. 
		if(age <per.age) return -1;
		else if(age > per.age) return 1;
		else return 0;
	}
	
	
	
}
public class ComparableTest2 {
	public static void main(String[] args) {
		ArrayList<Person> plist = new ArrayList<>();
		plist.add(new Person(68,"이순재"));
		plist.add(new Person(23,"제니"));
		plist.add(new Person(53,"엄정화"));
		
		//Arrays.sort(plist);
		Collections.sort(plist);
		System.out.println(plist);
	}

}
