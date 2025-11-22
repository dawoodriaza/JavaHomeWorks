package com.ga.oop;

public class Variable {
public static int classVariable  = 0;
public int instanceVariable = 0;
public Variable(){
            classVariable++;
            instanceVariable++;
}
public void displayValue(){
    System.out.println("Class Variable "+   classVariable);
    System.out.println("Instance Variable "+   instanceVariable);
}

    public static void main(String[] args) {
        Variable obj1 = new Variable();
        Variable obj2 = new Variable();
        Variable obj3 = new Variable();

        obj1.displayValue();
        obj2.displayValue();
        obj3.displayValue();

        System.out.println("Final Value of Class variable " + Variable.classVariable);

    }
    }
