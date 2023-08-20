package com.edu.bank.Test;

import java.awt.Cursor;
import java.nio.channels.AcceptPendingException;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest1 {

	public static void main(String[] args) {
		/*
		 * 1. Account 타입의 배열을 생성 
		 * 		: 111,120000.0,국민은행
		 * 		: 222,3400000.0,신한은행
		 * 		: 333,90000.0,하나은행
		 * 2. 김국민이라는 고객이 1번에서 생성된 배ㅐ열을 가짐
		 * 		-> 김국민에게는 국민은행 통장, 신한은행 통장, 하나은행 통장을 개설... 
		 * 3. 반복문을 사용해서 김국민이 개설한 통장의 정보를 출력하시오
		 */
	
		//1번
		Account acc1 = new Account(111,120000.0,"국민은행");
		Account acc2 = new Account(222,3400000.0,"신한은행");
		Account acc3 = new Account(333,90000.0,"하나은행");
		Account[] acccounts = {acc1,acc2,acc3};
		
		//2번
		Customer cust = new Customer("김국민") ;
		cust.setAccounts(acccounts);

		//3번
		System.out.println(cust.getName()+"님이 개설한 통장 정보입니다.");
		
		for(Account acc : cust.getAccounts()) {
			System.out.println(acc);
		}
		
		System.out.println("===============================");
		//1. 김국민이 개설한 통장 중에서 국민은행 통장을 찾아서 
		// 해당 통장의 잔액을 출금 
		for(Account acc : cust.getAccounts()) {	
			if (acc.getBankName().equals("국민은행")) {
				System.out.println(acc.getBalance());
				break;
			}
		}
		
		//2. 김국민이 개설한 통장에서 모든 통장의 잔액의 총합을 출력 
		double total = 0;
		
		for(Account acc : cust.getAccounts()) {
			total += acc.getBalance();
		}
		System.out.println(total);
		
		//3. 김국민이 개설한 통장 중에서 가장 많은 잔액이 들어있는 통장의 이름, 해당 잔액을 출력
		double maxMoney = 0;
		for(Account acc : cust.getAccounts()) {
			if (acc.getBalance() >= maxMoney) {
				maxMoney = acc.getBalance();
			}
		}
		for(Account acc : cust.getAccounts()) {	
			if (acc.getBalance()== maxMoney) {
				System.out.println(acc.getBankName()+", "+acc.getBalance());
				break;
			}
		}
	
		
		
	}

}
