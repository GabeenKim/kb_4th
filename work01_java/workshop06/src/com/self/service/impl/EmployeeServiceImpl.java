package com.self.service.impl;

import java.util.ArrayList;

import com.self.service.EmployeeService;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeServiceImpl implements EmployeeService {	
	private ArrayList<Employee> emps = new ArrayList<>();

	//1.static private 객체 생성
	static private EmployeeServiceImpl service = new EmployeeServiceImpl();
	
	//2.생성자 private로 접근 제한
	private EmployeeServiceImpl() {
		System.out.println("Employee 객체 생성...");
	}
	
	//3.객체 생성 전 접근할 수 있는 메소드 생성
	public static EmployeeServiceImpl getInstance() {
		return service;
	}
	
	@Override
	public void addEmployee(Employee e) {
		boolean find = false;
		for(Employee emp :emps) {
			if(emp.getName()==e.getName()) {
				find = true;
				System.out.println("이미 존재하는 회원입니다.");
				return;
			}
		}
		if(!find) {
			emps.add(e);
			System.out.println(e.getName()+"님이 회원으로 등록 되었습니다.");
		}
	}
	
	@Override
	public void deleteEmployee(String name) {
		boolean find = false ; 
		for(Employee emp :emps) {
			if(emp.getName().equals(name)) {
				find = true;
				System.out.println(emp.getName()+"님이 삭제 되었습니다.");
				emps.remove(emp);
				break;
			}
		}
		if(!find) System.out.println("삭제 대상이 존재하지 않습니다.");
	}
	
	//수정
	@Override
	public void updateEmployee(double salary, String dept, int deptno, String name) {
		for(Employee e:emps) {
			if(e!=null && e instanceof Manager) {
				if(e.getName().equals(name)) {
					e.changeSalary(salary);
					((Manager)e).changeDept(dept);	
					((Manager)e).setDeptno(deptno);				
				}			
			}
		}
	}
	
	public void updateEmployee(double salary, String tech, double bonus, String name) {	
		for(Employee e:emps) {
			if(e!=null && e instanceof Engineer) {
				if(e.getName().equals(name)) {
					e.changeSalary(salary);
					((Engineer)e).changeBonus(bonus);
					((Engineer)e).changeTech(tech);
				}
			}	
		}
		
	}
	//특정한 위치에 있는 사람의 정보를 수정 
	public void updateEmployee(double salary, String str, String name, int idx) {	
		Employee e = emps.get(idx);
		
		e.changeSalary(salary);
		e.changeName(name);
		
		if(e instanceof Manager) ((Manager) e).changeDept(str);
		if(e instanceof Engineer) ((Engineer) e).changeTech(str);
		
	}
	
	//검색
	@Override
	public ArrayList<Employee> findEmployeeByName(String name) {
		ArrayList<Employee> temp = new ArrayList<>();
		for(Employee emp : emps) {
			if(emp.getName().equals(name)) temp.add(emp); 
		}
		return temp;
	}
	@Override
	public ArrayList<Employee> findEmployeeByDeptno(int deptNo) {
		ArrayList<Employee> temp = new ArrayList<>();
		for(Employee emp : emps) {
			if(emp instanceof Manager) {
				if(((Manager) emp).getDeptno()==deptNo) temp.add(emp); 
			}
		}
		return temp;
	}
	@Override
	public ArrayList<Employee> findEmployeeByTech(String tech) {
		ArrayList<Employee> temp = new ArrayList<>();
		for(Employee emp : emps) {
			if(emp instanceof Engineer) {
				if(((Engineer)emp).getTech().equals(tech)) temp.add(emp); 
			}
		}
		return temp;
	}
	
	//출력
	@Override
	public void printAllEmployee() {
		for(Employee e : emps) {
			if(e!=null) {
				System.out.println(e);
			}
		}
	}
	@Override
	public void printAllManager() {
		for(Employee e : emps) {
			if(e!=null) {
				if(e instanceof Manager) System.out.println(((Manager) e).getDetails());
			}
		}
	}

	@Override
	public void printAllEngineer() {
		for(Employee e : emps) {
			if(e!=null) {
				if(e instanceof Engineer) System.out.println(((Engineer) e).getDetails());
			}
		}
	}

	@Override
	public double getAnnualSalary(String name) {
		double annualSalary =0.0;
		for(Employee e: emps) {
			if(e!=null) {
				if(e.getName().equals(name)) {
					if(e instanceof Engineer) annualSalary = e.getSalary()*12 + ((Engineer) e).getBonus();
					annualSalary = e.getSalary()*12;
				}
			}
		}
		return annualSalary;
	}

	@Override
	public double getTotalCost() {
		double totalCost =0.0;
		for(Employee e: emps) {
			if(e!=null) {
				totalCost += getAnnualSalary(e.getName());
			}
		}
		return totalCost;
	}

	
}
