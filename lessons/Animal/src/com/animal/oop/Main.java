package com.animal.oop;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        Animals animal = new Animals("Lion",50,true,4);
        Animals elephant = new Animals("Elephant",25,true,4);
        System.out.println(animal.getName());
        System.out.println(animal.getTopSpeed());
        System.out.println(animal.isEndangered());
        System.out.println(animal.getNumLegs());
        animal.setName("Tiger");
        System.out.println(animal.getName());

        animal.setNumLegs(3);
        System.out.println(animal.getNumLegs());
        animal.formattedString();


        elephant.formattedString();
        String [] animals = {"Dog","Lion","Tiger","Horse","Cow","Cat","cheetah"};

        for( String aName :animals){
            if (aName.equals("Dog")){
                System.out.println();
                animal.setTopSpeed(70);
            }



        }

    }
}
