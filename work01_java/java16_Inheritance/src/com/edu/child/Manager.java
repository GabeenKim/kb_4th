/*
 * employee
 *    | 
 * manager 상속 관계 시 중요한 지점
 * 
 * 1. 자식 객체 생성 시 무조건 부모 객체를 먼저 생성한다. 
 * 2. 부모에게서 물려받는 필드에 값 주입은 super()생성자 혹은 super.setXxx() 사용 -> 즉 부모것을 통해서
 * 3. 부모에게서 물려받은 메소드는 자식 클래스에서 구현부를 자식에게 맡게 고쳐 쓴다. -> 메소드 오버라이딩
 * 		메소드 오버라이딩 : 선언부는 모두 일치, 구현부는 반드시 다르게 구현. 
 * 
 */
package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

//Child Class
public class Manager extends Employee {
	private String dept;

	public Manager(String name, MyDate birthday, double salary, String dept) {
		super(name, birthday, salary);
		this.dept = dept;
	}

//	public Manager(String dept) {
//		//자식 생성자 첫라인에서는 무조건 부모 생성자 호출이 발생
//		//내가 설정해주지 X : 부모 기본 생성자 호출
//		//부모 명시적 생성자 호출
//		super();	//생략되어 있어도 무조건 있다고 생각하셈
//		this.dept = dept;
//	}
	
//	public Manager(String name, MyDate birthday, double salary,String dept) {
//		super(name, birthday, salary); //부모필드 값 주입
//		this.dept = dept; //자식만의 멤버 값 주입 
//	}
//
	public String getDetails() {
		return super.getDetails()+ " dept : "+ dept;
	}
	
	
}
