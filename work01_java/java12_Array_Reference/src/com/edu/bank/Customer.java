package com.edu.bank;


public class Customer {
	private String custName;
	private int ssn;
	
	private Account[] accounts = new Account[3]; 
	
	public static final int BASIC_SSN = 1234;
	//주입
	public Customer(){}
	public Customer(String custName, int ssn) {
		this.custName = custName;
		this.ssn = ssn;
	}
	public Customer(String custName) {
		this(custName,BASIC_SSN);
	}
	
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	
	//기능	
	public Account[] getAccounts() {
		return accounts;
	}
	public String getName() {
		return custName;
	}
	public String getCustomerInfo() {
		return custName + ", " + ssn;
	}

}
