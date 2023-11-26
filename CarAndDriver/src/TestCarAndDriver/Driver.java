package TestCarAndDriver;

public class Driver extends Car {
	private Car car = new Car();

	public Driver() {

	}

	// method drive
	void drive() {
		car.setGas(getGas() - 1);
		System.out.print("You drive the car." + "\n");
		if (car.getGas().equals(0)) {
			System.out.print("game over." + "\n");
		}
		display();
	}

	// method boost
	void boosters() {
		if (car.getGas() < 3) {
			System.out.print("You have less then 3 gas." + "\n");
		} else {
			System.out.print("You boosted for 3 gas." + "\n");
			car.setGas(getGas() + 3);
		}
		display();
	}

	// method refuel
	void refuel() {
		if (car.getGas() > 8) {
			System.out.print("You have more then 8 gas." + "\n");
		} else {
			System.out.print("You refuel for 2 gas." + "\n");
			car.setGas(getGas() + 2);
		}
		display();
	}

	void display() {
		System.out.printf("Gas remaining: %s/10" + "\n", car.getGas());
	}

}
