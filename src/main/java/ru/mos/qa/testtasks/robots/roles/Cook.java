package ru.mos.qa.testtasks.robots.roles;

import ru.mos.qa.testtasks.robots.Robot;
import ru.mos.qa.testtasks.robots.features.MovementTypes;
import ru.mos.qa.testtasks.robots.features.Diesel;

public class Cook extends Robot {

	public Cook() {
		super("Робот-повар", MovementTypes.WALK, new Diesel(80));
	}

	@Override
	public void move() {
		System.out.println(getName() + " идёт на кухню");
	}


	@Override
	public void doWork() {
		fuelSystem.consume();
		System.out.println(getName() + " готовит еду");
	}
}