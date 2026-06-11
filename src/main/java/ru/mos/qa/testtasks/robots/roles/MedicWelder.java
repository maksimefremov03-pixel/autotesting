package ru.mos.qa.testtasks.robots.roles;

import ru.mos.qa.testtasks.robots.Robot;
import ru.mos.qa.testtasks.robots.features.MovementTypes;
import ru.mos.qa.testtasks.robots.features.Hybrid;
import ru.mos.qa.testtasks.robots.features.Atomic;
import ru.mos.qa.testtasks.robots.features.Electric;

public class MedicWelder extends Robot {

	public MedicWelder() {
		super("Робот-медик-сварщик", MovementTypes.WALK, new Hybrid(new Atomic(), new Electric(100)));
	}

	@Override
	public void move() {
		System.out.println(getName() + " идёт к больному или на стройку");
	}

	@Override
	public void doWork() {
		fuelSystem.consume();
		System.out.println(getName() + " лечит больного или сваривает детали");
	}
}