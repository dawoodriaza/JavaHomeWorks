package com.ga.subclasses.automobile;

public class Main {
    public static void main(String[] args) {
        HondaAccord accord = new HondaAccord();
        System.out.println(accord.getYear());
        System.out.println(accord.getMake());
        System.out.println(accord.getModel());
        accord.startEngine();
    }
}
