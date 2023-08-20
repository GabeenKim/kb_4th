package com.edu.capsulation;
/*
 * 오늘 날짜를 저장하는 클래스 
 * valid한 값만 할당되도록 제어문 사용
 */
public class MyDate {
	//private: 허용범위 - 같은 클래스에서만 접근 가능. 
	private int month;
	private int day;
		
	//public MyDate(){} 컴파일러가 아무 생성자도 없으면 해당 기본 생성자를 자동생성. 생성자는 클래스의 접근 제어자를 따름
	public void setMonth(int month) {
		//필드 초기화와 다르게 값 주입 전에 제어문 적용 가능 
		if(month>=1 && month <=12) 
			this.month = month;
		else { 
			System.out.println("invalid month");
			System.exit(0);
		}
	}
	
	public void setDay(int day) {
		
		switch(month) {
		// 많을 때를 디폴트로 돌려라.
		case 2:
			if(day>=1 && day <=28) 
				this.day = day;
			else {
				System.out.println("invalid day");
				System.exit(0);
			}
			
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if(day>=1 && day <=30) 
				this.day = day;
			else {
				System.out.println("invalid day");
				System.exit(0);
			}
			
			break;
		default :
			if(day>=1 && day <=31) 
				this.day = day;
			else {
				System.out.println("invalid day");
				System.exit(0);
			}
			break;
		}
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	
}
