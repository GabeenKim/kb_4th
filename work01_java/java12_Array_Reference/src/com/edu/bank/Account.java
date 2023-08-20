package com.edu.bank;
//제어문 추가 
/*
* 1.입금(deposit)시 1천원 이상의 금액만 입금 
*   -> else "입금액은 1000원 이상이어야 합니다." 출력 후 원래 호출한 지점으로 return 시켜라. 
* 2. 출금(withdraw)시 잔액보다 더 큰 금액은 출금이 안 되도록 
* 	 -> else "출금액이 잔액보다 더 큽니다." retrun 
*/

public class Account {
	private int accNumber;
	private double balance;
	private String bankName;
	
	//버릇처럼 기본생성자를 넣자! 
	public Account() {}
	//필드가 주입되는 통로를 생성자로
	public Account(int accNumber, double balance, String bankName) {
		this.accNumber = accNumber;
		this.balance = balance;
		this.bankName = bankName;
	}
	
	//기능
	public int getAccNumber() {
		return accNumber;
	}
	public double getBalance() {
		return balance;
	}
	public String getBankName() {
		return bankName;
	}
	//입금
	public void deposit(double amt) {
		if (amt >= 1000.0) balance += amt;
		else {
			System.out.println("입금액은 1000원 이상이어야 합니다.");
			return ;
		}
	}
	//출급
	public void withdraw(double amt) {
		if (balance >= amt) balance += amt;
		else {
			System.out.println("출금액이 잔액보다 많습니다.");
			return ;
		}
	}
	//필드값 리턴 
	@Override
	public String toString() {
		return accNumber + "-" + 
				bankName +"-" + 
				balance
			    ;
	}
	
	
	
	
	
}
