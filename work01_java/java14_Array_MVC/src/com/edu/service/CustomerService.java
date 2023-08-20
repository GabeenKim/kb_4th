package com.edu.service;
/*
 * 아울렛에서 상품을 구매하는 고객에 대한 기능을 다루는 서비스 클래스...
 * 제일 중요한건 메소드 데피니션. 기능 정의
 * -> identify가 제일 중요하고 반환값과 인자값이 잘 정의되어져 있어야 한다. 
 * 기능들만 정의되어져 있다. 
 * 하나의 기능은 독자적인 완벽한 서비스로 이해하자. 
 */

import com.edu.vo.Customer;
import com.edu.vo.Product;

public class CustomerService {
	
	//1. 특정 고객이 구입한 상품을 리턴하는 기능 ...
	public Product[] getProducts(Customer c) {
		return c.getProducts();
	} 
	
	
	//2. 특정 고객이 구입한 상품들의 maker들만 리턴
	public String[] getAllProductMaker(Customer c) {
		String[] temp = new String[c.getProducts().length];
		int idx = 0;
		for(Product p : c.getProducts()) {
			 temp[idx++] = p.getMaker();
		}
		return temp;
	}
	
	//3. 모든 고객 중에서 특정한 고객을 검색...
	public Customer findCustomerBySsn(Customer[] custs, int ssn) {
		Customer customer = null ;

		for(Customer cust :custs) {
			if(cust.getSsn()==ssn) {
				customer = cust;
			}
		}
		return customer;
	}
	
	//4. 모든 고객 중에서 특정한 동네에 사는 고객을 검색...
	public Customer[] findCustomerByAddress(Customer[] custs, String address) {
		Customer[] temp = new Customer[custs.length];
		int idx = 0;
		for(Customer cust :custs) {
			if(cust.getAddress()==address) {
				temp[idx++] = cust;
			}
		}
		return temp;
	}
	
	//5. ...

}
