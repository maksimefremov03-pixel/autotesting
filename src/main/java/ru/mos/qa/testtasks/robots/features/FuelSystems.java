package ru.mos.qa.testtasks.robots.features;

public abstract class FuelSystems {
	protected FuelTypes fuelType;
	protected int level;
	protected int maxLevel;

	public FuelSystems(FuelTypes fuelType) {
		this.fuelType = fuelType;
	}

	public FuelTypes getFuelType() { return fuelType; }
	public abstract boolean needsRefuel();
	public abstract void refuel();
	public abstract void consume();
    
	public int getLevel() { return level; }
}