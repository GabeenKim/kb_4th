package com.edu.test;

import com.edu.service.ProductService;
import com.edu.vo.Product;

public class ProductServiceTest2 {

	public static void main(String[] args) {
		Product[] products = {
				new Product("신라면",1200,10,"농심"),
				new Product("삼다수 생수",1200,2,"농심"),
				new Product("옥시크린",34000,1,"LG"),
				new Product("아이폰",1000000,1,"애플")
		};
		
		//2. Service 클래스 객체 생성 
		// 프로덕트서비스 클래스의 기능들이 메모리에 올라가고
		//호출해서 사용...
		ProductService service = new ProductService();
		
		service.printAllProductMaker(products);
		
		service.getTotalPrice(products);
		System.out.println(service.getTotalPrice(products));
		
		Product[] pros = service.getMorePrice(products,10000);
		for(Product p : pros ) {
			if(p == null) continue;
			System.out.println(p);
		}
		
		Product[] pros2 = service.getSameCompany(products,"농심");
		for(Product p : pros2 ) {
			if(p == null) continue;
			System.out.println(p)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ;
		}
	}

}
