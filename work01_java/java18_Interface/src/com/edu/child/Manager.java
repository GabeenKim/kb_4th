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
	
	//부서 변경
	public void changeDept(String dept) {
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}

	public String toString() {
		return super.toString()+ " dept : "+ dept;
	}	
}
