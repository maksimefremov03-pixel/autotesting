package ru.mos.qa.testtasks.robots.features;

import ru.mos.qa.testtasks.robots.features.FuelSystems;

public class Electric extends FuelSystems {
	private int chargeRate;

	public Electric(int maxLevel) {
		super(FuelTypes.ELECTRIC);
		this.maxLevel = maxLevel;
		this.level = maxLevel;
	}

	@Override
	public boolean needsRefuel() {
		return level <= 20;
	}

	@Override
	public void refuel() {
		level = maxLevel;
		System.out.println("Батарея заряжена");
	}
    
	@Override
	public void consume() {
		level = Math.max(0, level - 1);
	}
}