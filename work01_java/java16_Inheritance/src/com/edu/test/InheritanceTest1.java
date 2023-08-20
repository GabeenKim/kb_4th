package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.util.MyDate;

public class InheritanceTest1 {

	public static void main(String[] args) {
		Manager m = new Manager("James", new MyDate(1990,1,1), 40000.0, "IT");
		Engineer e =  new Engineer("Bob", new MyDate(2000,5,1), 50000.0,"java",20000.0);
		Secretary s = new Secretary("David", new MyDate(1990,1,1), 40000.0, "gabeen");
		
		System.out.println(m.getDetails());
		System.out.println(e.getDetails());
		System.out.println(s.getDetails());
	}

}
