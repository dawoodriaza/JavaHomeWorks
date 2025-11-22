package com.ga.subclasses.automobile;

public class HondaAccord extends Automobile{
    @Override
    public int getYear(){
        return 2025;
    }

    @Override
    public String getMake() {
        return super.getMake();
    }

    @Override
    public String getModel() {
        return "Accord";
    }

    @Override
    public void startEngine() {
        super.startEngine();
    }
}
