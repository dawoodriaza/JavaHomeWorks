package com.ga.oop;

public class Honda {

        private String name;
        private int year;
        private int noOfTypes;
        private int maxSpeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNoOfTypes() {
        return noOfTypes;
    }

    public void setNoOfTypes(int noOfTypes) {
        this.noOfTypes = noOfTypes;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrakingSystem() {
        return brakingSystem;
    }

    public void setBrakingSystem(String brakingSystem) {
        this.brakingSystem = brakingSystem;
    }

    private String brakingSystem;


}
