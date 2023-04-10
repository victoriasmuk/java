package com.victoriasmuk.zookeeper;

public class Mammal {
	private int energy;
	
	public Mammal() {
		this.energy = 100;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public String displayEnergy() {
		return("Current Energy: " + this.energy);
	}
}