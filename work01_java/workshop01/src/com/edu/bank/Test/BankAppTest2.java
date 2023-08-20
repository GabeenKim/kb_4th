package com.edu.bank.Test;

import java.util.Scanner;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankAppTest2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Customer kb1 = new Customer("동은",12345678);
		Customer kb2 = new Customer("지수",87654321);
		
		Customer [] customer = new Customer[2];
		
		customer[0] = kb1;
		customer[1] = kb2;
		
		for(int i = 0 ; i<customer.length; i++) {
			int accountNum = sc.nextInt();
			double balance = sc.nextDouble();
			String bankName = sc.next();
			customer[i].openAccount(new Account(accountNum, balance, bankName));
		}
		
		for(int i = 0 ; i<customer.length; i++) {
			double depositMoney = sc.nextDouble();
			double withdrawMoney = sc.nextDouble();
			
			customer[i].getAccount().deposit(depositMoney);
			customer[i].getAccount().withdraw(withdrawMoney);
			
			depositMoney = sc.nextDouble();
			customer[i].getAccount().deposit(depositMoney);
		}
		
		sc.close();

		System.out.print(kb1.getName() +"님의 계좌 잔고 : ");
		System.out.println(kb1.getAccount().getBalance() + "원");
		
		System.out.print(kb1.getName() +"님의 계좌 정보 : ");
		System.out.println(kb1.getAccount().getAccountInfo());
		
		System.out.println("=========================================================");
		
		System.out.print(kb2.getName() +"님의 계좌 잔고 : ");
		System.out.println(kb2.getAccount().getBalance()+ "원");
		
		System.out.print(kb2.getName() +"님의 계좌 정보 : ");
		System.out.println(kb2.getAccount().getAccountInfo());
	}

}
