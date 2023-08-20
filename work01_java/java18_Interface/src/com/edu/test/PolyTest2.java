package com.edu.test;
import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest2 {

	public static void main(String[] args) {
//		Employee m = new Manager("James", new MyDate(1990,1,1), 40000.0, "IT");
//		Employee eg =  new Engineer("Bob", new MyDate(2000,5,1), 50000.0,"java",20000.0);
//		Employee s = new Secretary("David", new MyDate(1990,1,1), 40000.0, "gabeen");
		
		//부모클래스인 employee의 배열에 매니저,엔지니어 등을 다 담을 수 있다. => 이종간의 집합체
		//상속이 서포트되기 때문에 같은 데이터 타입이 아닐지라도 배열 사용 가능 
		Employee[] emps = {
				new Manager("James", new MyDate(1990,1,1), 40000.0, "IT"),
				new Engineer("Bob", new MyDate(2000,5,1), 50000.0,"java",20000.0),
				new Secretary("David", new MyDate(1990,1,1), 40000.0, "gabeen"),
				new Engineer("Tomas", new MyDate(2000,5,1), 60000.0,"python",20000.0)
			};		
		System.out.println("========직원정보==========");
		for(Employee e : emps)
			System.out.println(e);
		
		System.out.println("========직원들의 연봉 정보 출력========");
		double anualSalary =0.0;
		for(Employee e : emps) {
			if(e instanceof Engineer) anualSalary  =e.getSalary()*12 + ((Engineer) e).getBonus();
			else anualSalary = e.getSalary()*12;
			System.out.println(e.getName()+"님의 연봉 : "+anualSalary);
		}
	}
}
