package com.edu.cons.test;

class Date{
	int year;
	int month;
	int day;
	
	//생성자
	public Date(int year, int month, int day) {
		//필드 초기화...주입의 통로를 생성자로 결정
		this.year = year;
		this.month = month;
		this.day = day;
	}
	/*
	 * String + Non-String => String으로 변환됨. 따라서 스트링으로 반환해주는 것이 제일 좋음.  
	 */
	public String getDate() {
		return year +"-" + month +"-" + day;
	}
}
//Server(EE에서)의 역할을 하는 클래스 
class WhiteBoard {
	//1.field 선언
	String madeCompany;
	float price;
	boolean scratch;
	char size;
	//추가...제조일자 
	Date madeDate;
	
	//2. field에 값을 주입하는 기능(void|인자값)
	public void setWhiteBoard(String madeCompany, float price, 
								boolean scratch, char size, Date madeDate) {
		//필드 초기화 
		this.madeCompany = madeCompany;
		this.price = price;
		this.scratch = scratch;
		this.size = size;
		this.madeDate = madeDate;
	}
	
	//3. 주입된 field 값을 반환(???|인자값x)
	public String getWhiteBoard() {
		return madeCompany+","+price+","+scratch+","+size + ","+madeDate.getDate() ; 
	}
}

//테스트클래스
public class WhiteBoardTest {

	public static void main(String[] args) {
		//객체생성 = 메모리에 로딩하는 작업 new 활용  
		WhiteBoard wb = new WhiteBoard();
		//생성자로 값 주입 => date라는 객체가 생성되고 동시에 값 주입 
//		Date d = new Date(2023, 07, 04);
		
		//1.set~~() 호출 -> 필드값이 채워진다. 
		//인자값의 개수, 순서, 타입이 일치해야 한다. 
		wb.setWhiteBoard("동신사", 34000.0f, false, 'L', new Date(2023, 07, 04));
		
		//2.get~~() 호출 -> 반환값을 출력하기 위해 print 따로 또 해주기
		System.out.println(wb.getWhiteBoard());
		
	}

}
