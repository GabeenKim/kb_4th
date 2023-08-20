package com.edu.test;
import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.service.EmployeeService;
import com.edu.util.MyDate;

public class PolyTest3 {

	public static void main(String[] args) {
		Employee[] emps = {
				new Manager("James", new MyDate(1990,1,1), 40000.0, "IT"),
				new Engineer("Bob", new MyDate(2000,5,1), 48000.0,"java",100.0),
				new Secretary("David", new MyDate(1990,1,1), 25000.0, "gabeen"),
				new Engineer("Tomas", new MyDate(2000,5,1), 58000.0,"python",100.0),
				new Manager("Jay", new MyDate(1990,1,1), 65000.0, "IT")
			};		
		//Service 객체 생성 -> 메모리에 기능들을 로딩시킴.
		EmployeeService service = new EmployeeService();
		
		//서비스 기능을 호출 
		System.out.println("========1. 직원정보 출력==========");
		service.printAllEmployee(emps);
		
		
		System.out.println("========2. 특정한 직원을 검색========");
		System.out.println(service.findEmployee(emps,"James"));
		
	
		System.out.println("========3. 동일한 부서의 직원 검색========");
		Employee[] temp = service.findEmployeeByDept(emps,"IT");
		for(Employee e:temp) {
			if(e ==null) continue;
			System.out.println(e);
		}
		
		System.out.println("========4. 특정 직원의 연봉 검색========");
		System.out.println(service.getAnnunalSalary(new Engineer("Tomas", new MyDate(2000,5,1), 58000.0,"python",100.0) ));
		
		System.out.println("========5. 직원의 총 인건비를 검색========");
		System.out.println(service.getTotalCost(emps));
	}
}
