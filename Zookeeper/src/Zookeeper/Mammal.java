package Zookeeper;

public class Mammal {
	protected  int energyLevel = 100;

	public Mammal() {
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	void displayEnergy() {
		System.out.printf("Energy Level : %d"+"\n", energyLevel);
		getEnergyLevel();
	}
}
