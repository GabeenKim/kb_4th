package com.edu.datatype;
/*
 * 오전에 정리한 자바의 DataType을 이해할 수 있는 클래스를 작성 
 * 2개의 클래스를 한 번에 작성할 때는 
 * 1. main()을 가지고 있는 클래스 앞에만 public을 지정 
 * 2. public으로 지정된 클래스 명으로 java파일이 저장되어야 한다. 
 */

//참조형 클래스 데이터타입 
class Date{
	int year;
	int month;
	int day;
	
	public void setDate(int year, int month, int day) {
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
		Date d = new Date();
		
		//1.set~~() 호출 -> 필드값이 채워진다. 
		//인자값의 개수, 순서, 타입이 일치해야 한다. 
		d.setDate(2023, 07, 04);
		wb.setWhiteBoard("동신사", 34000.0f, false, 'L', d);
		
		//2.get~~() 호출 -> 반환값을 출력하기 위해 print 따로 또 해주기
		System.out.println(wb.getWhiteBoard());
		
	}

}
