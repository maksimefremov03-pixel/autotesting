package ru.mos.qa.testtasks.robots.features;

import ru.mos.qa.testtasks.robots.features.InternalCombustion;

public class Diesel extends InternalCombustion {
	public Diesel(int maxLevel) {
		super(FuelTypes.DIESEL, maxLevel);
	}
}