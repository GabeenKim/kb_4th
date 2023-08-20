package com.self.service;

import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public interface EmployeeService {
	void addEmployee(Employee e);
	void deleteEmployee(String name);

	void updateEmployee(double salary, String tech, double bonus, String name);
	void updateEmployee(double salary, String dept,int deptno,  String name);

	Employee findEmployeeByName(String name);
	Employee[ ] findEmployeeByDeptno(int deptno);
	
	void printAllEmployee();
	void printAllManager();
	void printAllEngineer();
	
	double getAnnualSalary(String name);
	double getTotalCost();
}

