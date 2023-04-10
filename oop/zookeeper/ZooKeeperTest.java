package com.victoriasmuk.Zookeeper;

public class ZookeeperTest {

	public static void main(String[] args) {
		Gorilla Gorilla = new Gorilla();
		
		System.out.println(Gorilla.throwSomething());
		System.out.println(Gorilla.throwSomething());
		System.out.println(Gorilla.throwSomething());
		System.out.println(Gorilla.eatBananas());
		System.out.println(Gorilla.eatBananas());
		System.out.println(Gorilla.useClimb());
		System.out.println(Gorilla.displayEnergy());
		
		Bat Bat = new Bat();
		
		System.out.println(Bat.attackTown());
		System.out.println(Bat.attackTown());
		System.out.println(Bat.attackTown());
		System.out.println(Bat.eatHumans());
		System.out.println(Bat.eatHumans());
		System.out.println(Bat.fly());
		System.out.println(Bat.displayEnergy());
	}
}