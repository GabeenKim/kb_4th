package com.edu.test;

//인터페이스는 추상메소드들의 집합 
//추상메소드? : 구현부가 없고 선언부만으로 이루어진 메소드 
interface Flyer{
	void fly(); //무조건 앞에 public abstract가 붙는다.
	void land();
	void takeOff();
}
//클래스는 객체의 타입으로서 작용되기에 완벽한 구현체여야 함. 따라서 모든 메소드가 구현되어 있어야함. 
class Bird implements Flyer {

	//물려받아서 구현체 구현 -> 오버라이딩
	@Override
	public void fly() {
		System.out.println("Bird Fly...");
	}

	@Override
	public void land() {
		System.out.println("Bird land...");
	}

	@Override
	public void takeOff() {
		System.out.println("Bird takeOff...");
	}
	
	public String layEggs() {
		return "알을 까다";
	}
}

class SuperMan implements Flyer{

	@Override
	public void fly() {
		System.out.println("SuperMan Fly...");
	}

	@Override
	public void land() {
		System.out.println("SuperMan land...");
	}

	@Override
	public void takeOff() {
		System.out.println("SuperMan takeOff...");
	}
	public String stopBullet() {
		return "망토로 총알을 막는다.";
	}
}



public class InterfaceTest1 {

	public static void main(String[] args) {
		//추상메소드가 있는 것으로는 객체를 생성할 수 없다. abstact가 하나라도 있으면 객체 생성 절대 안됨. 메모리에 못 올라감.
		//Flyer f = new Flyer;
		
		//인터페이스는 객체 생성 시 타입으로서는 작동 됨. 해당 클래스의 부모이기 때문에.
		//Polymorphism 
		Flyer b = new Bird(); 
		Flyer s = new SuperMan();
		
		b.fly();
		s.fly();
		
		System.out.println(((Bird)b).layEggs());
		
	}

}
