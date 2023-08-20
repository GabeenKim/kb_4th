package com.edu.test;

//사용자 정의 exception 
class ZeroBoom extends Exception {
	ZeroBoom(){
		this("This is ZeroBoom exception");
	}
	ZeroBoom(String str){
		super(str);
	}
}


class User{
	public void go() throws ZeroBoom{
		int i = 10;
		int j = 0;
		
		System.out.println("go()...진입..."); //2.
		//j에 0이 할당되면 X ->j==0이라면 Exception 발생 
		if(j==0) throw new ZeroBoom("분모가 0이면 안됩니다."); //던지면
		
		System.out.println("ArithmeticException() 터짐");
	}
}
public class UserException4 {
	public static void main(String[] args) {
		User user = new User();
		System.out.println("go()...호출..."); //1.
		//여기로 옴 
		//3. 
		try {
			user.go();
		}catch(ZeroBoom e) {
			System.out.println(e.getMessage());
		}
	}

}
