package ru.mos.qa.testtasks.robots.roles;

import ru.mos.qa.testtasks.robots.Robot;
import ru.mos.qa.testtasks.robots.features.MovementTypes;
import ru.mos.qa.testtasks.robots.features.Hybrid;
import ru.mos.qa.testtasks.robots.features.Gasoline;
import ru.mos.qa.testtasks.robots.features.Electric;

public class WelderCook extends Robot {

	public WelderCook() {
		super("Робот-сварщик-повар", MovementTypes.DRIVE, new Hybrid(new Gasoline(120), new Electric(100)));
	}

	@Override
	public void move() {
		System.out.println(getName() + " едет на стройку или на кухню");
	}

	@Override
	public void doWork() {
		fuelSystem.consume();
		System.out.println(getName() + " сваривает детали или готовит еду");
	}
}