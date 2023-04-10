package com.victoriasmuk.zookeeper;

public class Bat extends Mammal {
	public Bat() {
		super();
		this.setEnergy(300);
	}
	public String fly() {
		this.setEnergy(getEnergy()-50);
		return("Flies away");
	}
	public String eatHumans() {
		this.setEnergy(getEnergy()+25);
		return("Eats a human");
	}
	public String attackTown() {
		this.setEnergy(getEnergy()-100);
		return("Attacks town!");
	}
}
