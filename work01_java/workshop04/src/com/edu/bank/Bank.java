package com.edu.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Bank {
	public static final int MAX_CUSTOMERS = 100;
	public Customer[] customers;
	public int numberOfCustomers;
	
	public Bank() {
		customers =new Customer[MAX_CUSTOMERS];
		numberOfCustomers = 0;
	}
	
	public void addCustomer(String name, int rrn, int zipCode, String region, String city) {
		if(numberOfCustomers ==  MAX_CUSTOMERS) {
			System.out.println("���̻� ȸ���� ����� �� �����ϴ�.");
			return;
		}
		customers[numberOfCustomers++] =  new Customer(name, rrn, zipCode, region, city);

	}
	
	public Customer getCustomer(int rrn) {
		for(int i=0; i<numberOfCustomers; i++) {
			if(customers[i]== null) continue;
			if(customers[i].getRrn() == rrn) {
				return customers[i];
			}
			
		}
		
		return new Customer();
	}
	//고객 삭제하기
	public void deleteCustomer(int rrn) {
		for(int i=0; i<numberOfCustomers; i++) {
			if(customers[i]== null) continue;
			if(customers[i].getRrn() == rrn) {
				customers[i]=null;
			}
		}
	}
	
	public void showAllCustomer() {
		if(numberOfCustomers == 0) {
			System.out.println("ȸ���� �ƹ��� �����ϴ�.");
			return;
		}
		//rrn 번호 오름차순으로 정렬하여 전체 고객 보여주기
		
		Arrays.sort(customers,new Comparator<Customer>(){
			@Override
			public int compare(Customer c1, Customer c2) {
				if(c1.getRrn()>c2.getRrn()) return -1;
				else if (c1.getRrn()<c2.getRrn()) return 1;
				else return 0;
			}
		});

		for(int i=0; i<numberOfCustomers; i++) {
			if(customers[i]==null)continue;
			System.out.println(customers[i]);
		}
	}
	
}
