package Zookeeper;

public class Bat extends Mammal {
		// method fly 
	public Bat() {
		energyLevel = 300;
	}
	void fly() {
		energyLevel -= 50;
		System.out.print("Shhh !! Bat is flying !"+"\n");
	}
	// method eatHumans
	void eatHumain() {
		energyLevel += 25;
		System.out.print("Bat attack a humain !!!"+"\n");
	}
	// method attackTown
	void attackTown() {
		energyLevel -=100;
		System.out.print("Bat attack a town !!"+"\n");
	}
}
