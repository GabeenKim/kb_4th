package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.play.Dice;

public class DiceCImpl implements Dice {

	public int value;

	public DiceCImpl() {
		System.out.println("::"+getClass().getName()+" 생성자....");
	};
	public DiceCImpl(int value) {
		super();
		this.value = value;
		System.out.println("::"+getClass().getName()+" 생성자....");
	}
	
	@Override
	public int getValue() {
		return value;
	}
	@Override
	public void selectedNumber(){
		value = new Random().nextInt(6) + 1;
	}

	@Override
	public String toString() {
		return "DiceAImpl [value=" + value + "]";
	}

}
