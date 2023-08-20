package com.edu.collection.test;
/*
 * 순서 없고
 * 중복 허용 안 함. 
 */

import java.util.HashSet;
import java.util.Set;

public class HashSetTest1 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("탁재훈");
		set.add("이수근");
		set.add("김희철");
		set.add("탁재훈");
		set.add("서장훈");
		
		System.out.println(set);
		
		//1.set에 저장된 데이터의 개수를 출력
		System.out.println(set.size());
		
		//2.김준호라는 멤버가 저장되어 있는지 여부 
		if(set.contains("김준호"))System.out.println("O");
		else System.out.println("X");
		
		//3. 이수근을 삭제 
		if(!set.isEmpty()) set.remove("이수근");
		System.out.println(set);
		
		//4. 모든 멤버 삭제
		if(!set.isEmpty()) set.clear();
		//5. set이 비어져 있는지 확인
		if(set.isEmpty()) System.out.println(set);
		
	}

}
