package Zookeeper;

public class TestZookeeper extends Gorilla  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla gorilla = new Gorilla();
		gorilla.Throw();
		gorilla.Throw();
		gorilla.Throw();
		gorilla.displayEnergy();
		
		Bat bat = new Bat();
		bat.attackTown();
		bat.attackTown();
		bat.attackTown();
		bat.eatHumain();
		bat.eatHumain();
		bat.fly();
		bat.fly();
		bat.displayEnergy();
	}

}
