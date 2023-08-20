package com.edu.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.edu.domain.Person;



public class Manager {
	private Map<Integer,Person> map;
	//1
	private static Manager manager = new Manager(100);
	
	//2
	private Manager(int size){
		map = new HashMap<>();
		System.out.println(" 싱글톤 패턴...");
	}
	//3
	public static Manager getInstance(){
		return manager;
	}
	
	
	
	public void printAllPersonInfo(){
		//
		Set<Integer> set = map.keySet();
		for(int ssn : set) {
			System.out.println(ssn+" PersonInfo : "+map.get(ssn));
		}
		
	}	
	
	public void addPerson(Person person){		
		//추가하려는 사람이 있을떄는 추가되지 않도록 작성
		if(map.containsKey(person.getSsn())) {
			System.out.println(person.getName()+"님은 이미 존재하는 회원입니다.");
			return;
		}
		map.put(person.getSsn(),person);
		System.out.println(person.getName()+"님이 등록 되었습니다.");
	}
	
	public void deletePerson(int ssn){
		// 삭제 대상이있을때만 삭제되도록
//		if(map.containsKey(ssn)) {
//			System.out.println(map.get(ssn).getName()+"님이 삭제되었습니다.");
//			map.remove(ssn);
//		}
//		else System.out.println("삭제할 대상이 존재하지 않습니다.");
		//리턴타입 활용해서 containsKey()생략 
		Person p = map.remove(ssn);
		if(p==null) {
			System.out.println("삭제할 대상이 존재하지 않습니다."); 
			return;
		}else {
			System.out.println(p.getName()+"님이 삭제되었습니다.");
		}
	}
	
	public Person findPerson(int ssn){
		//
		return map.get(ssn);
	}//

	public ArrayList<Person> findPerson(String addr){
		ArrayList<Person> temp = new ArrayList<>();
		for(int ssn : map.keySet()) {
			if(map.get(ssn).getAddress().equals(addr)) temp.add(map.get(ssn));
		}
		return temp;
	}

	public void updatePerson(Person p, int ssn){	
		//map에는 set(수정) 함수가 별도로 존재하지 않고 키에 해당하는 값을 다시 put하면 오버라이팅 되는 것! 
		if(map.containsKey(ssn)) {
			map.put(ssn,p);
			System.out.println("수정되었습니다.");
		}else {
			System.out.println("수정할 대상이 존재하지 않습니다."); 
		}
		
		
	}
}











