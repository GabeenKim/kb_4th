package com.edu.service;


import java.util.ArrayList;
import java.util.List;

import com.edu.exception.DuplicateISBNException;
import com.edu.exception.ISBNNotFoundException;
import com.edu.exception.QuantityException;
import com.edu.parent.Book;

public class BookServiceImpl implements BookService {
	private ArrayList<Book> list;
	
	//싱글톤
	private static BookServiceImpl mgr = new BookServiceImpl();

	private BookServiceImpl() {
		System.out.println("생성자 호출");
		list = new ArrayList<Book>();
	
	}

	public static BookServiceImpl getInstance() {
		return mgr;
	}

	@Override
	public void add(Book b) throws DuplicateISBNException {
		boolean find = false; 
		for(Book bk : list) {
			if(bk.getIsbn() == b.getIsbn()) {
				find=true;
				throw new DuplicateISBNException("이미 존재하는 책입니다.");
			}
		}
		//리스트에 book을 추가
		if(!find) {
			list.add(b);
			System.out.println(b.getTitle()+"책이 등록되었습니다.");
		}
	}

	@Override
	public List<Book> search() {
		//모든 book을 반환
		return list;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		
			/*
			   1.팔려는 책이 있지만 재고가 부족하다면 QuantityException 예외를 발생
			   2.팔려는 책이 있고 재고도 넉넉하다면 기존의 수량을 업데이트함
			   3.팔려는 책의 isbn을 발견하지 못하면 ISBNNotFoundException 예외를 발생
			*/
			boolean find = false; 
			for(Book b : list) {
				if(b.getIsbn()==isbn) {
					find = true;
					if(b.getQuantity()>=quantity) {
						b.setQuantity(b.getQuantity()-quantity);
						System.out.println(b.getTitle()+"책이 판매 되었습니다. 현재 재고 : "+b.getQuantity());
					}else {
						throw new QuantityException("재고가 부족합니다."); 
					}
				}
			}
			if(!find) throw new ISBNNotFoundException("판매하려는 책이 존재하지 않습니다.");		
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException{
		/*
		  1. 구매하려는 isbn을 찾을수 없으면 ISBNNotFoundException 예외를 발생
		  2. 구매하려는 isbn이 있다면 총 책의 수량을 업데이트 시킴
		 
		 */		
		boolean find = false; 
		for(Book b : list) {
			if(b.getIsbn()==isbn) {
				find = true;
				b.setQuantity(b.getQuantity()+quantity);
				System.out.println(b.getTitle()+"책이 구매 되었습니다. 현재 재고 : "+b.getQuantity());
			}
		}
		if(!find) throw new ISBNNotFoundException("구매하려는 책이 존재하지 않습니다.");
	}

	@Override
	public int getTotalAmount() {
		// 도서관의 모든 책의 총 가격금액을 반환
		int totalAmount = 0;
		for(Book b : list) {
			totalAmount += b.getPrice()*b.getQuantity();
		}
		return totalAmount;
	}

}
