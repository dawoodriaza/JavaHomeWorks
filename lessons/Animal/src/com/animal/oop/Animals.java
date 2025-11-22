package com.animal.oop;

public class Animals {
    private  int numLegs;
    private int topSpeed;
    private boolean isEndangered ;
    private String name;

    public Animals(String name,int topSpeed, boolean isEndangered, int numLegs){
        this.name =name;
        this.topSpeed = topSpeed;
        this.isEndangered = isEndangered;
        this.numLegs = numLegs;

    }
    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) {
        if(numLegs <= 3){
            System.out.println("Cannot be less than four. setting it to 4");
            this.numLegs = 4;

        }else{
        this.numLegs = numLegs;}
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public boolean isEndangered() {
        return isEndangered;
    }

    public void setEndangered(boolean endangered) {
        isEndangered = endangered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void formattedString() {
        System.out.println( "The " + name + " has a top speed of " + topSpeed + " mph. It has "
                + numLegs + " legs and is " + (isEndangered ? "a danger animal." : "not a danger animal.") );
    }
}
