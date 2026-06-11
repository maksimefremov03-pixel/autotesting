package ru.mos.qa.testtasks.robots.roles;

import ru.mos.qa.testtasks.robots.Robot;
import ru.mos.qa.testtasks.robots.features.MovementTypes;
import ru.mos.qa.testtasks.robots.features.Electric;

public class Medic extends Robot {

	public Medic() {
		super("Медицинский робот", MovementTypes.WALK, new Electric(100));
	}

	@Override
	public void move() {
		System.out.println(getName() + " идёт к пациенту");
	}

	@Override
	public void doWork() {
		fuelSystem.consume();
		System.out.println(getName() + " делает анализы и проводит операции");
	}
}