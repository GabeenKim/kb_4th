package com.edu.bank;

public class Account {
	public int accNumber;
	public double balance;
	public String bankName;
	
	//주입
	public Account(int accNumber, double balance, String bankName) {
		this.accNumber = accNumber;
		this.balance = balance;
		this.bankName = bankName;
	}
	
	//기능
	
	
	public String getAccountInfo() {
		return "계좌번호 : "+ accNumber + ", " + 
				"잔액 : " + balance +", " + 
				"은햏명 : "+bankName ;
	}
	
	public int getAccNumber() {
		return accNumber;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amt) {
		balance += amt;
	}
	
	public void withdraw(double amt) {
		balance -= amt;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	
	
	
}
