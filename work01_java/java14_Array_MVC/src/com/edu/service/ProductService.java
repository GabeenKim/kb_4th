package com.edu.service;

import com.edu.vo.Product;

// Product들을 관리하는 기능만으로 구성된 서비스 클래스...
// 메소드 identifier를 얼마나 잘 작성하는가가 중요. 네이밍 
// 메소드를 정의하려면 리턴 타입하고 인자값 이거 정확하게 작성하기 
// 구현 
public class ProductService {
	//1. 배열 안에 있는 모든 상품들의 메이커를 출력 
	public void printAllProductMaker(Product[] products) {
		for(Product p : products) {
			System.out.println(p.getMaker());
		}
	}
	
	//2. 상품들의 총 구입액을 리턴하는 기능 
	public int getTotalPrice(Product[] products){
		int total = 0;
		//구현
		for(Product p : products) {
			total += p.getPrice()*p.getQuantity();
		}
		return total;
	}
	
	//3. 특정 금액 이상의 상품을 리턴하는 기능
	public Product[] getMorePrice(Product[] products, int price){
		Product[] temp = new Product[products.length];
		int idx = 0;
		for(Product p : products) {
			if(p.getPrice()>= price) {
				temp[idx++] = p;
			}
		}
		return temp;
	}
	
	//4. 동일한 회사의 제품들만 리턴하는 기능 
	public Product[] getSameCompany(Product[] products, String company){
		Product[] temp = new Product[products.length];
		int idx = 0;
		for(Product p : products) {
			if(p.getCompany().equals(company)) {
				temp[idx++] = p;
			}
		}
		return temp;
	}
	
	//5. 구입한 상품들의 평균가격을 리턴하는 기능. 
	public double getAvgPrice(Product[] products){
		return getTotalPrice(products)/products.length;
	}
	
	
}
