package com.edu.service;
/*
 * 존재 유무를 반드시 확인하고 진행해야 하는 작업 -> add,delete,update.
 */

import java.util.ArrayList;

import com.edu.domain.Employee;
import com.edu.domain.Person;
import com.edu.domain.Student;
import com.edu.domain.Teacher;

public class Manager {
	/*private Person[ ] p;
	private int index;
	*/
	
	private ArrayList<Person> list;
	
	public Manager(int size){
		list = new ArrayList<>();
	}
	public void getPersons(){
		for(Person p : list) {
			System.out.println(p);
		}
	}	
	
	public void addPerson(Person person){	
		//추가하려는 사람이 없을때만 추가되도록 작성
		boolean find = false;
		for(Person p :list) {
			if(p.getSsn()==person.getSsn()) {
				find = true;
				System.out.println("존재하는 회원입니다.");
				return;
			}
		}
		if(!find) {
			list.add(person);
			System.out.println(person.getName()+"님이 회원으로 등록 되었습니다.");
		}
	}
	
	public void deletePerson(int ssn){
		//삭제하려는 대상이 있을때에만 삭제가 되도록 작성
		boolean find = false ; //flag값
		for(Person p : list) {
			if(p.getSsn()==ssn) {
				find = true;
				System.out.println(p.getName()+"님이 삭제 되었습니다.");
				list.remove(p);
				break;
			}
		}
		if(!find) System.out.println("삭제 대상이 존재하지 않습니다.");
	}

	
	public Person findPerson(int ssn){
		Person p = null;
		for(Person per : list) {
			if(per.getSsn() == ssn)
				p = per;
		}
		return p;
	}

	public ArrayList<Person> findPerson(String addr){
		ArrayList<Person> temp = new ArrayList<>();
		for(Person p : list) {
			if(p.getAddress().equals(addr)) temp.add(p);
		}
		return temp;
	}

	//str은 중복방지를 위한 변수 : 학생이면 학생번호, 선생이면 과목 등등...
	//ssn = PK 기본키는 절대 수정의 대상이 되면 안됨
	//수정은 기본 키 외에 속성이 대상이 되어야 함. 따라서 ssn은 안 주어짐. 
	public void updatePerson(String name,int age, String addr, String str,int k){	
		
		//특정한 위치에 있는 사람의 정보를 수정함
		//메소드의 인자값을 잘 활용해서 모든 객체의 정보가 수정될수 있도록 로직을 작성
		Person p = list.get(k);
		 
		//공통사항은 별도로 
		p.setName(name);
		p.setAge(age);
		p.setAddress(addr);
		//p가 어떤 신분인지 모르니 instanceof 이용해야 함.
		if(p instanceof Student) ((Student) p).setStuId(str);
		if(p instanceof Teacher) ((Teacher) p).setSubject(str);
		if(p instanceof Employee) ((Employee) p).setDept(str);
	}
}
