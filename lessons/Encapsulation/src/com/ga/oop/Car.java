package com.ga.oop;

public class Car {

    private int modelYear;
    private String modelName;

    public Car(int year, String name){
        this.modelYear = year;
        this.modelName = name;
    }



    public void fullThrottle(){
        System.out.println("The car is going as fast as it can!");
    }
    public void speed(int maxSpeed){
        System.out.println("Max Speed Is: " + maxSpeed );
    }

    public static void main(String[] args) {
        Car car = new Car(2008, "Civic");
        car.fullThrottle();
        car.speed(80);

        System.out.println(car.modelYear + " " + car.modelName);
        System.out.printf("%d : %s",car.modelYear, car.modelName);

        Car honda = new Car(2005, "ZDK");
        honda.fullThrottle();
        honda.speed(40);
        System.out.println(honda.modelYear+ " " + honda.modelName);

        Honda honda1 = new Honda();
        honda1.setName("City");
        honda1.setYear(2021);
        System.out.println(honda1.getName()+ honda1.getYear());
        
    }
}
