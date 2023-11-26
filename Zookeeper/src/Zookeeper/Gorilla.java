package Zookeeper;

public class Gorilla extends Mammal {
	public Gorilla() {
}
	// method Throw - lose 5 energyLevel
	public void Throw() {
		energyLevel -= 5 ;
		System.out.print("Gorilla Throw something."+"\n");
	}
	// method EatBananas - gain 10 energyLevel
	public void EatBannanas() {
		energyLevel -= 10 ;
		System.out.print("Eat a bannnanas."+"\n");

	}
	// method climb - lose 10 energyLEvel
	public void Climb() {
		energyLevel -= 10 ;
		System.out.print("Gorilla climb a tree."+"\n");

	}
	
}
