package ru.mos.qa.testtasks.robots.features;

import ru.mos.qa.testtasks.robots.features.InternalCombustion;

public class Gasoline extends InternalCombustion {
	public Gasoline(int maxLevel) {
		super(FuelTypes.GASOLINE, maxLevel);
	}
}