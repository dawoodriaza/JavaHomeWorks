package com.ga.subclasses.automobile;

public class DodgeRam implements IAutomobile, ITowVehicle {
    public DodgeRam() {
        super();
    }

    @Override
    public int getYear() {
        return 0;
    }

    @Override
    public String getMake() {
        return "";
    }

    @Override
    public String getModel() {
        return "";
    }

    @Override
    public void startEngine() {

    }

    @Override
    public int getCarryCapacity() {
        return 0;
    }

    @Override
    public int getTowingCapacity() {
        return 0;
    }

    @Override
    public String getFuelType() {
        return "";
    }
}
