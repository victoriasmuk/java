package com.victoriasmuk.CarAndDriver;

public class Driver extends Car {
	public Driver() {
		super();
	}
	public void drive() {
		System.out.println("Driving...");
		this.setGas(getGas()-1);
		this.display();
	}
	public void useBooster() {
		System.out.println("Uses booster!");
		this.setGas(getGas()-3);
		this.display();
	}
	public void refuel() {
		System.out.println("Refueling! +2 gas");
		this.setGas(getGas()+2);
		this.display();
	}
}