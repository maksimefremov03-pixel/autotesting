package ru.mos.qa.testtasks.robots.roles;

import ru.mos.qa.testtasks.robots.Robot;
import ru.mos.qa.testtasks.robots.features.MovementTypes;
import ru.mos.qa.testtasks.robots.features.Atomic;

public class Almighty extends Robot {
 
	public Almighty() {
		super("Супер-робот", MovementTypes.FLY, new Atomic());
	}

	@Override
	public void move() {
		System.out.println(getName() + " летит");
	}


	@Override
	public void doWork() {
		fuelSystem.consume();
		System.out.println(getName() + " может всё: лечить, варить, готовить");
	}
}