package com.edu.loop.test;

/*
 * if문과 함께 사용되는 반목문의 키워드 
 * if + break
 * if + continue 
 */
public class BasicLoopTest2 {

	public static void main(String[] args) {
		int total = 0;
		
//		System.out.println("=======break=======");
//		
//		for(int member =1 ; member<= 10; member++) {
//			if(total>=30) break;
//			
//			total += member;
//			System.out.println(total);
//		}
		System.out.println("=======continue=======");
		
		for(int num =1; num <= 10 ; num ++) {
			if(num%2==0) continue;
			//짝수일때는 실행하지 않고 건너뜀. 뛴 후에 증감식을 거쳐서 다음 단계로 넘어감. 
		}

	}

}
