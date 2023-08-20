package com.self.service.impl;

import com.self.service.EmployeeService;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeServiceImpl implements EmployeeService {
	public static final int SIZE = 100;
	
	private Employee[] emps;
	int idx =0;
	//테스트파일에서 객체 생성시 생성자의 인자값을 통해 사이즈를 넘겨 받은 후, 
	//배열을 현 클래스에서 생성하여 각 메소드에서 이를 이용하기!
//	public EmployeeServiceImpl(int size) {
//		emps = new Employee[size];
//	}
	
	//상수를 이용해서 사이즈 설정 
	public EmployeeServiceImpl() {
		emps = new Employee[SIZE];
	}

	@Override
	public void addEmployee(Employee e) {
		if(idx == SIZE) {
			System.out.println("정원이 초과되어 회원 등록이 불가합니다.");
			return;
		}
		emps[idx++]= e;		
	}
	
	@Override
	public void deleteEmployee(String name) {
		for(int i=0; i<idx; i++) {
			if(emps[i].getName().equals(name)) {
				for(int j=i; j<idx; j++) {
					//이름이 같은 객체가 i번째인데, 이 자리에 뒷 자리 값을 덮어 씌움으로써 삭제 기능?
					emps[j] = emps[j+1];
				}
				emps[idx] = null;
				idx--;
			}
		}
	}
	
	@Override
	public void updateEmployee(double salary, String dept, int deptno, String name) {
		for(Employee e:emps) {
			if(e==null) continue;
			if(e instanceof Manager) {
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
			if(e==null) continue;
			if(e instanceof Engineer)
			if(e.getName().equals(name)) {
				e.changeSalary(salary);
				((Engineer)e).changeBonus(bonus);
				((Engineer)e).changeTech(tech);
			}
		}
		
	}
	@Override
	public Employee findEmployeeByName(String name) {
		Employee e = null;
		for(Employee emp : emps) {
			if(emp==null) continue;			
			if(emp.getName().equals(name))
				e = emp;
				break; //1명만 찾을 것이므로 찾았으면 break 해주는게 효율적임. 
		}
		return e;
	}
	@Override
	public Employee[] findEmployeeByDeptno(int deptNo) {
		Employee[] temp = new Employee[emps.length];
		int cnt =0;
		for(Employee e : emps) {
			if(e == null) continue;
			if(e instanceof Manager) {
				if(((Manager)e).getDeptno()== deptNo) {
					temp[cnt++] = e;
			}
			}
		}
		return temp;
	}
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

	//getAnnualSalary()이용하기! 
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
