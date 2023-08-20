package com.self.vo;

import com.self.util.MyDate;

public class Engineer extends Employee{
	private String tech;
	private double bonus;
	
	public Engineer(String name, MyDate birthDate, double salary, String tech, double bonus) {
		//부모의 필드에 주입 
		super(name, birthDate, salary);
		this.tech = tech;
		this.bonus = bonus;
	}	
	
	//tech -> change가 set보다 더 적합 
	public void changeTech(String tech) {
		this.tech = tech;
	}
	//bonus->change가 set보다 더 적합 
	public void changeBonus(double bonus) {
		this.bonus = bonus;
	}	
	
	public String getTech() {
		return tech;
	}
	public double getBonus() {
		return bonus;
	}
	
	public String getDetails() {
		return super.toString()+","+tech+","+bonus;
	}	
}
