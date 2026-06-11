package ru.mos.qa.testtasks.robots.features;

import ru.mos.qa.testtasks.robots.features.FuelSystems;

public class InternalCombustion extends FuelSystems {
	private int consumptionRate;

	public InternalCombustion(FuelTypes fuelType, int maxLevel) {
		super(fuelType);
		this.maxLevel = maxLevel;
		this.level = maxLevel;
	}

	@Override
	public boolean needsRefuel() {
		return level <= 1;
	}

	@Override
	public void refuel() {
		level = maxLevel;
		System.out.println("Бак заправлен");
	}

	@Override
	public void consume() {
		level = Math.max(0, level - 1);
	}
}