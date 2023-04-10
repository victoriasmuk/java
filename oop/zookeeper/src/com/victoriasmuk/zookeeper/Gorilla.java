package com.victoriasmuk.zookeeper;

public class Gorilla extends Mammal {
	public Gorilla() {
		super();
	}
	public String throwSomething() {
		this.setEnergy(getEnergy()-5);
		return ("Throws somethings");
	}
	public String eatBananas() {
		this.setEnergy(getEnergy()+10);
		return("Ate a yummy banana");	
	}
	public String useClimb() {
		this.setEnergy(getEnergy()-10);
		return("Climbs a tree");
	}
}
