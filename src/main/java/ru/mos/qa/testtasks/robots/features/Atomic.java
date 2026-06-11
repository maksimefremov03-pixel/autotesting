package ru.mos.qa.testtasks.robots.features;

import ru.mos.qa.testtasks.robots.features.FuelSystems;

public class Atomic extends FuelSystems {
	private int yearsSinceRefuel = 0;

	public Atomic() {
		super(FuelTypes.NUCLEAR);
		this.maxLevel = 50;
		this.level = 50;
	}

	@Override
	public boolean needsRefuel() {
		return yearsSinceRefuel >= 50;
	}

	@Override
	public void refuel() {
		yearsSinceRefuel = 0;
		level = 50;
		System.out.println("Стержень заменён");
	}

	@Override
	public void consume() {
		yearsSinceRefuel++;
		level = 50 - yearsSinceRefuel;
	}
}