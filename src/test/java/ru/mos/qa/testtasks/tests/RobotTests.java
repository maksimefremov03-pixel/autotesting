package ru.mos.qa.testtasks.robotstests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.Robot;
import ru.mos.qa.testtasks.robots.roles.*;
import ru.mos.qa.testtasks.robots.features.MovementTypes;
import ru.mos.qa.testtasks.robots.features.FuelTypes;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTests {

    @Test
    public void testMedic() {
        Medic robot = new Medic();
        
        assertEquals(MovementTypes.WALK, robot.getMovement());
        assertEquals(FuelTypes.ELECTRIC, robot.getFuel());
        
        robot.move();
        robot.refuel();
        robot.doWork();
    }

    @Test
    public void testWelder() {
        Welder robot = new Welder();
        
        assertEquals(MovementTypes.DRIVE, robot.getMovement());
        assertEquals(FuelTypes.GASOLINE, robot.getFuel());
        
        robot.move();
        robot.refuel();
        robot.doWork();
    }

    @Test
    public void testCook() {
        Cook robot = new Cook();
        
        assertEquals(MovementTypes.WALK, robot.getMovement());
        assertEquals(FuelTypes.DIESEL, robot.getFuel());
        
        robot.move();
        robot.refuel();
        robot.doWork();
    }

    @Test
    public void testMedicWelder() {
        MedicWelder robot = new MedicWelder();
        
        assertEquals(MovementTypes.WALK, robot.getMovement());
        assertEquals(FuelTypes.HYBRID, robot.getFuel());
        
        robot.move();
        robot.refuel();
        robot.doWork();
    }

    @Test
    public void testWelderCook() {
        WelderCook robot = new WelderCook();
        
        assertEquals(MovementTypes.DRIVE, robot.getMovement());
        assertEquals(FuelTypes.HYBRID, robot.getFuel());
        
        robot.move();
        robot.refuel();
        robot.doWork();
    }

    @Test
    public void testAlmighty() {
        Almighty robot = new Almighty();
        
        assertEquals(MovementTypes.FLY, robot.getMovement());
        assertEquals(FuelTypes.NUCLEAR, robot.getFuel());
        
        robot.move();
        robot.refuel();
        robot.doWork();
    }

    @Test
    public void testPolymorphism() {
        Robot[] robots = {
            new Medic(),
            new Welder(),
            new Cook(),
            new MedicWelder(),
            new WelderCook(),
            new Almighty()
        };
        
        for (Robot robot : robots) {
            robot.move();
            robot.refuel();
            robot.doWork();
        }
    }

    @Test
    public void testFuelLevelDecreases() {
        Welder robot = new Welder();
        int initialLevel = robot.getFuelLevel();
        
        robot.doWork();
        
        assertTrue(robot.getFuelLevel() < initialLevel);
    }

    @Test
    public void testLowFuelLevel() {
        Welder robot = new Welder();
        while (!robot.needsRefuel()) {
            robot.doWork();
        }

        assertTrue(robot.getFuelLevel() <= 1);
    }

    @Test
    public void testCorrectFuelTypes() {
        assertEquals(FuelTypes.NUCLEAR, new Almighty().getFuel());
        assertEquals(FuelTypes.GASOLINE, new Welder().getFuel());
        assertEquals(FuelTypes.DIESEL, new Cook().getFuel());
        assertEquals(FuelTypes.ELECTRIC, new Medic().getFuel());
        assertEquals(FuelTypes.HYBRID, new MedicWelder().getFuel());
        assertEquals(FuelTypes.HYBRID, new WelderCook().getFuel());
    }

    @Test
    public void testAtomicRefuel() {
        Almighty robot = new Almighty();
        
        for (int i = 0; i < 49; i++) {
            robot.doWork();
            assertFalse(robot.needsRefuel());
        }
        
        robot.doWork();
        assertTrue(robot.needsRefuel());
    }

    @Test
    public void testInternalCombustionRefuel() {
        Welder robot = new Welder();
        
        while (!robot.needsRefuel()) {
            robot.doWork();
        }
        
        robot.refuel();
        assertFalse(robot.needsRefuel());
    }

    @Test
    public void testElectricRefuel() {
        Medic robot = new Medic();
        
        while (robot.getFuelLevel() > 20) {
            robot.doWork();
        }
        
        assertTrue(robot.needsRefuel());
        
        robot.refuel();
        assertEquals(100, robot.getFuelLevel());
    }

    @Test
    public void testHybridRefuel() {
        MedicWelder robot = new MedicWelder();
        
        int operations = 0;
        while (!robot.needsRefuel()) {
            robot.doWork();
            operations++;
        }
        
        assertTrue(robot.needsRefuel());
        
        robot.refuel();
        assertFalse(robot.needsRefuel());
    }
}