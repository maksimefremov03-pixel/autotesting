package ru.mos.qa.testtasks.robots;

import ru.mos.qa.testtasks.robots.features.MovementTypes;
import ru.mos.qa.testtasks.robots.features.FuelSystems;
import ru.mos.qa.testtasks.robots.features.FuelTypes;

public abstract class Robot {
	private String name;
	private MovementTypes movement;
	protected FuelSystems fuelSystem;

	public Robot(String name, MovementTypes movement, FuelSystems fuelSystem) {
		this.name = name;
		this.movement = movement;
		this.fuelSystem = fuelSystem;
	}

	public String getName() { return name; }
	public MovementTypes getMovement() { return movement; }
	public FuelTypes getFuel() { return fuelSystem.getFuelType(); }

	public boolean needsRefuel() {
		return fuelSystem.needsRefuel();
	}
 
	public int getFuelLevel() {
		return fuelSystem.getLevel();
	}

	public void refuel() {
		if (fuelSystem.needsRefuel()) {
			fuelSystem.refuel();
		} else {
			System.out.println(name + " ещё не нуждается в заправке. Уровень: " + fuelSystem.getLevel() + "%");
		}
	}

	public abstract void move();
	public abstract void doWork();
}