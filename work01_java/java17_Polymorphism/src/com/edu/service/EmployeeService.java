package com.edu.service;

import java.util.Arrays;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.parent.Employee;

/*
 * heterogeneous Collection
 * 이기종간의 집합체를 관리하는 기능만으로 작성된 서비스 클래스 
 * 가장 기본적인 기능은 CRUD
 * 
 * 1. 가장 원시적인 레벨의 서비스 기능 정의 
 * 		상속 X일 때 : Manager, Engineer, Secretary 라는 unrelated 관계들일 때 
 * 		-> step1 
 * 			>>>추가 관련 기능(C)
 * 			public void addManager(Manager m){//}
 * 			public void insertEngineer(Engineer eg){//} ...
 * 			crud가 12개가 생성됨...가독성 ↓ 
 * 		-> step2 
 * 			>>>추가 관련 기능(C)
 * 			public void addManager(Manager m){//}
 * 			public void addEngineer(Engineer eg){//} ...
 * 			상속이 없을 시, 완벽한 오버로딩은 아닐지라도 메소드 명을 일관되게 작성해서 가독력을 ↑
 * 
 * 		상속 O일 때 :   Manager, Engineer, Secretary가 부모로 Employee가 있을 때 
 * 		employee 타입으로 이기종간의 서브 클래스들을 단일하게 관리할 수 있다. 		
 * 		-> step3 
 * 			>>>추가 관련 기능(C)
 * 			public void addEmployee(Manager m){//}
 * 			public void addEmployee(Engineer eg){//} ...
 * 			메소드 명은 같고 argument가 달라짐.=> 메소드 오버로딩, 수가 많아져도 하나의 기능으로 파악할 수 있음. 
 * 			그러나, 개수는 step1이랑 동일함(인자가 다르기 때문에 메소드 개수를 줄일 수 없음)
 * 			=> 파라미터의 타입도 부모로 만들어서 개수를 1개로 관리,,?
 * 		-> step4
 * 			>>>추가 관련 기능(C) ... Polymorphic Argument
 * 			public void addEmployee(Employee e){ <-여러개니까 배열
 * 				if(e instanceof Manager){
 * 					//
 * 				}else if(e instanceof Engineer){
 * 					//
 * 				}else{
 * 					//
 * 				}
 * 			-> 오버로딩을 이용해서 가독성과 구현성능을 높이고 
 * 				instanceof를 이용해서 제어하며 디테일한 작업 가능 
 * 
 */
//Polymorphic Argument에 대한 기능적인 이해
public class EmployeeService {
	//1. 모든 직원의 정보를 출력하는 기능 ..선언부 먼저 
	public void printAllEmployee(Employee[] emps) {
		for(Employee e: emps) {
			System.out.println(e);
		}
	}
	
	//2. 모든 직원 중 특정한 직원을 검색하는 기능 정의
	//검색 : find~ search~()
	//서비스 클래스 기능(메소드)하나가 클라이언트의 요청에 매칭 
	//따라서 모든 직원을 넘겨주고 특정 조건에 사용할 인자 값을 같이 넘겨주기.
	public Employee findEmployee(Employee[] emps, String name) {
		Employee employee = null;
		for(Employee e: emps) {
			if(e.getName().equals(name)) {
				employee = e;
				break;
			}
		}
		
		return employee;
	}
	
	//3. 모든 직원 중에서 동일한 부서에서 일하는 직원들을(여러명일 수도 있으니 []) 검색 
	//ByDept를 붙여서 일관성도 유지하고 오버로딩에 위배되지 않음. 
	public Employee[] findEmployeeByDept(Employee[] emps, String dept) {
		//최대치로 잡아놓기, 리턴타입이 컨테이너면 temp 이용 
		Employee[] temp = new Employee[emps.length];
		int idx =0;
		for(Employee e: emps) {
			if(e instanceof Manager) {
				if(((Manager)e).getDept().equals(dept)) {
					temp[idx++] = e;
				}
			}
		}
		return temp;
	}
	
	//4. 특정한 직원의 연봉을 리턴
	public double getAnnunalSalary(Employee e) {
		double annualSalary =0.0;
		if(e instanceof Engineer) annualSalary = e.getSalary()*12+((Engineer)e).getBonus();
		else annualSalary = e.getSalary()*12;
		return annualSalary;
	}
	
	//5. 모든 직원의 총 인건비를 리턴
	public double getTotalCost(Employee[] ea) {
		double total =0;
		
		for(Employee e : ea) {
			if(e instanceof Engineer) total += e.getSalary()*12+((Engineer)e).getBonus();
			else total+= e.getSalary()*12;
		}
		
		return total;
	}
}











