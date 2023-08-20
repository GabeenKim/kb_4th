package com.edu.domain;

import com.edu.util.MyDate;

//직원에 대한 정보를 저장 
/*
 * <Access Modifier>
 * private, public -> 접근하는 범위를 지정하는 키워드
 *  생성자 overloading 
 *  :: 필수적인 정보로만 객체를 생성
 *  미처 입력되지 않은 정보는 기본값으로 채울 떄 반드시 필요한 기법
 *  이떄 다른 생ㅅ어자를 호출하기 위한 this 키워드를 사용한다. 
 */
public class Employee {
	private String name;
	private double salary;
	private MyDate birthDate;
	
	
	//salary의 기본값 지정 (상수로 지정)
	//비스듬히 옆으로 눕는 변수는 상수임.
	public static final double BASIC_SALARY = 100.0;
	
	public Employee() {}
	/* 
	 * 생성자 앞의 this는 같은 클래스 내에서 또 다른 생성자를 호출할 때.
	 */
	public Employee(String name, MyDate birthDate) {
		this(name,BASIC_SALARY,birthDate);
	}
	public Employee(String name, double salary, MyDate birthDate) {
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}


	
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public MyDate getBirthDate() {
		return birthDate;
	}
	
	@Override
		public String toString() {
			return name+", "+salary+", "+birthDate;
		}
	
}
