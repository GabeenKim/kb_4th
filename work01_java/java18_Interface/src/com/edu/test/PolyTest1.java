package com.edu.test;
/*
 * polymorphism : 부모 타입으로 다양한 자식 객체를 생성
 * <주의 사항>
 * 1. Object Casting
 * 2. Virtual Method Invocation
 */
import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest1 {

	public static void main(String[] args) {
		Employee m = new Manager("James", new MyDate(1990,1,1), 40000.0, "IT");
		Employee eg =  new Engineer("Bob", new MyDate(2000,5,1), 50000.0,"java",20000.0);
		Employee s = new Secretary("David", new MyDate(1990,1,1), 40000.0, "gabeen");
		
		//1.james의 부서를 it->marketing으로 변경 changeDept() 
		//Manager m1 = (Manager)m ;
		//m1.changeDept("marketing");
		
		//m은 employee타입인데, employee에 해당 메소드가 없음. 따라서 불러올 자식 클래스를 지정하고 
		//그것을 다시 자식 클래스 타입에 할당해야함. 
		((Manager) m).changeDept("marketing");
		
		/* 
		 * Virtual Method Invocation 원리 
		 * 상속관계의 오버라이딩된 메소드에서 
		 * 부모타입으로 자식객체를 생성했을 때 발생하는 원리 
		 * 
		 * 1. 컴파일 타입 메소드 -> 부모의 메소드가 호출된다.
		 * 2. 런타임 메소드 -> 실질적으로 생성된 자식 메소드가 호출된다. 
		 */
		
		//2.정보출력
		System.out.println(m);
		System.out.println(eg);
		System.out.println(s);
	}

}
