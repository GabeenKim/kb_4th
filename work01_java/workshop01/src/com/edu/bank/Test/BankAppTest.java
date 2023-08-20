package com.edu.bank.Test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankAppTest {

	public static void main(String[] args) {
		
		Customer kb1 = new Customer("동은",12345678);
		Customer kb2 = new Customer("지수",87654321);
		
		//Customer와 Account의 Hasing이 이뤄짐. 
		kb1.openAccount(new Account(652301, 300.5,"국민은행"));
		kb2.openAccount(new Account(333314, 500.5,"국민은행"));
		
		Account kb1Account = kb1.getAccount();
		Account kb2Account = kb2.getAccount();
		
		System.out.println("============문동은 님의 입출금 내역================");
		
		kb1Account.deposit(200.3);
		kb1Account.withdraw(100.8);
		kb1Account.deposit(200.3);
		
		System.out.print(kb1.getName() +"님의 계좌 잔고 : ");
		System.out.println(kb1Account.getBalance() + "원");
		
		System.out.print(kb1.getName() +"님의 계좌 정보 : ");
		System.out.println(kb1.getAccount().getAccountInfo());
		
		System.out.println("============문지수 님의 입출금 내역================");
		
		kb2Account.deposit(200.3);
		kb2Account.withdraw(100.8);
		kb2Account.deposit(200.3);
		
		
		System.out.print(kb2.getName() +"님의 계좌 잔고 : ");
		System.out.println(kb2Account.getBalance()+ "원");
		
		System.out.print(kb2.getName() +"님의 계좌 정보 : ");
		System.out.println(kb2Account.getAccountInfo());
	}

}
