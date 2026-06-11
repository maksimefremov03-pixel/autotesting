package ru.mos.qa.testtasks.robots.roles;

import ru.mos.qa.testtasks.robots.Robot;
import ru.mos.qa.testtasks.robots.features.MovementTypes;
import ru.mos.qa.testtasks.robots.features.Gasoline;

public class Welder extends Robot {

	public Welder() {
		super("Робот-сварщик", MovementTypes.DRIVE, new Gasoline(100));
	}

	@Override
	public void move() {
		System.out.println(getName() + " едет на стройку");
	}


	@Override
	public void doWork() {
		fuelSystem.consume();
		System.out.println(getName() + " сваривает детали");
	}
}