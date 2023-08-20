package com.edu.collection.test;

import java.util.ArrayList;

/*
 * 순서 있고
 * 중복허용 
 */

public class ArrayListTest1 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add("신동엽");
		list.add("이수근");
		list.add("강호동");
		list.add("신동엽");
		list.add("탁재훈");
		
		System.out.println(list);
		 
		//1. 세번째 강호동을 삭제.. 삭제 메시지도 함께 출력
		String name = (String) list.remove(2);
		System.out.println(name+"님이 삭제 되었습니다.");
		
		//2. 2번째 데이터를 아이유로 수정
		list.set(1,"아이유");
		System.out.println(list);
		
		//3. 탁재훈 앞에 김준호를 추가 
		int idx = list.indexOf("탁재훈"); 
		list.add(idx,"김준호");
		System.out.println(list);
		
		//4. 4번째 데이터 받아서 출력
		System.out.println(list.get(3));
		
		//5. 모든 데이터 삭제
		list.clear();
		System.out.println(list);
	}

}
