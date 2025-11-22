package com.ga.subclasses.automobile;

public class Automobile implements IAutomobile {
    @Override
    public int getYear() {
        return 2024;
    }

    @Override
    public String getMake() {
        return "Honda";
    }

    @Override
    public String getModel() {
        return "Acura ZDK";
    }

    @Override
    public void startEngine() {
        System.out.println("Vroom vromm vrommmmmmmm");
    }
}
