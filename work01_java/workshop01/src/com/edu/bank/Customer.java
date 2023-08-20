package com.edu.bank;

public class Customer {
	public String custName;
	public int ssn;
	
	public Account account;
	
	//주입
	public Customer(String custName, int ssn) {
		this.custName = custName;
		this.ssn = ssn;
	}
	
	public void openAccount(Account account) {
		this.account = account;
	}
	
	//기능	
	public Account getAccount() {
		return account;
	}
	
	public String getCustomerInfo() {
		return custName + ", " + ssn;
	}
	
	public String getName() {
		return custName;
	}

	
	
	
}
