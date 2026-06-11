package ru.mos.qa.testtasks.robots.features;

import ru.mos.qa.testtasks.robots.features.FuelSystems;

public class Hybrid extends FuelSystems {
    private FuelSystems primarySystem;
    private FuelSystems secondarySystem;
    
    public Hybrid(FuelSystems primary, FuelSystems secondary) {
        super(FuelTypes.HYBRID);
        this.primarySystem = primary;
        this.secondarySystem = secondary;
    }
    
    @Override
    public boolean needsRefuel() {
        return primarySystem.needsRefuel() || secondarySystem.needsRefuel();
    }
    
    @Override
    public void refuel() {
        if (primarySystem.needsRefuel()) {
            primarySystem.refuel();
        }
        if (secondarySystem.needsRefuel()) {
            secondarySystem.refuel();
        }
        System.out.println("Гибридная заправка выполнена!");
    }
    
    @Override
    public void consume() {
        primarySystem.consume();
        secondarySystem.consume();
    }
}