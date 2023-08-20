package com.self.service;

import java.util.ArrayList;

import com.self.vo.Employee;

public interface EmployeeService {
	void addEmployee(Employee e);
	void deleteEmployee(String name);

	void updateEmployee(double salary, String tech, double bonus, String name);
	void updateEmployee(double salary, String dept,int deptno,  String name);
	void updateEmployee(double salary, String str, String name,int idx);
	
	ArrayList<Employee> findEmployeeByName(String name);
	ArrayList<Employee> findEmployeeByDeptno(int deptno);
	ArrayList<Employee> findEmployeeByTech(String tech);
	
	void printAllEmployee();
	void printAllManager();
	void printAllEngineer();
	
	double getAnnualSalary(String name);
	double getTotalCost();
}

