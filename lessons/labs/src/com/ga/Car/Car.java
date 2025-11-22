package com.ga.Car;
/*
* 🚗 Lab 3: Car Prototype
⏱️ Estimated Time: 40 minutes

Model a realistic car with multiple phases of functionality.

🔹 Phase I : Constructor & Basic Behaviors
🧱 Constructor Parameters
make
model
year
color
seats
🏗️ Default Constructor Values
previousOwners → []
owner → "manufacturer"
running → false
🛠️ Methods
sell(newOwner)
Move current owner to the end of previousOwners
Set new owner
paint(newColor)
Update the car’s color
🔹 Phase II : Engine & Movement Controls
🛠️ Methods
start() → sets running = true
off() → sets running = false
driveTo(destination)
Works only when the car is running
Prints driving to <destination>
Returns true/false
park()
Works only when the car is not running
Prints parked!!
Returns true/false
🔹 Phase III : Passenger System
👥 Additional Constructor Parameter
passengers (optional; defaults to empty array)
🛠️ Methods
pickUp(name)
Only if car is running AND seats are available
Prints driving to pick up <name>
Adds passenger
Returns true/false
dropOff(name)
Only if car is running AND passenger exists
Prints driving to drop off <name>
Removes passenger
Returns true/false
passengerCount()
Returns number of passengers
💡 Note: Driver takes 1 seat but is not included in the passenger count.
*
*
* */
import java.util.ArrayList;
import java.util.List;

public class Car {

    private String make;
    private String model;
    private int year;
    private String color;
    private int seats;
    private String owner;
    private List<String> previousOwners;
    private boolean running;


    private List<String> passengers;


    public Car(String make, String model, int year, String color, int seats) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.seats = seats;
        this.owner = "manufacturer";
        this.previousOwners = new ArrayList<>();
        this.running = false;
        this.passengers = new ArrayList<>();
    }


    public void sell(String newOwner) {
        previousOwners.add(owner);
        owner = newOwner;
        System.out.println("car is sold to " + newOwner);
    }

    public void paint(String newColor) {
        color = newColor;
        System.out.println("car Pinainted " + newColor);
    }


    public void start() {
        running = true;
        System.out.println("car start");
    }

    public void off() {
        running = false;
        System.out.println("car is turned off");
    }

    public boolean driveTo(String destination) {
        if (running) {
            System.out.println("driving back " + destination);
            return true;
        } else {
            System.out.println("cannot drive back from pakistan");
            return false;
        }
    }

    public boolean park() {
        if (!running) {
            System.out.println("parked!!");
            return true;
        } else {
            System.out.println("can't park while running!");
            return false;
        }
    }


    public boolean pickUp(String name) {
        if (running && passengers.size() < seats - 1) {
            passengers.add(name);
            System.out.println("driving to pick up " + name);
            return true;
        } else if (!running) {
            System.out.println("cannot pick passengers, car is of");
        } else {
            System.out.println("no available seats to pick up " + name);
        }
        return false;
    }

    public boolean dropOff(String name) {
        if (running && passengers.contains(name)) {
            passengers.remove(name);
            System.out.println("Driving to drop off " + name);
            return true;
        } else if (!running) {
            System.out.println("cannot pick passengers, car is of");
        } else {
            System.out.println(name + " is not in the car");
        }
        return false;
    }

    public int passengerCount() {
        return passengers.size();
    }


    public String getOwner() { return owner; }
    public List<String> getPreviousOwners() { return previousOwners; }
    public String getColor() { return color; }
    public boolean isRunning() { return running; }


        public static void main(String[] args) {
            Car car = new Car("toyota", "corolla", 2020, "Red", 4);

            car.start();
            car.driveTo("Manamam");
            car.pickUp("Mohammed");
            car.pickUp("aLIYAN");
            System.out.println("Passengers: " + car.passengerCount());
            car.dropOff("Mohammed");
            System.out.println("Passengers: " + car.passengerCount());
            car.dropOff("ALIYAN");
            car.off();
            car.park();
            car.paint("Red");
            car.sell("Dawood");
        }

}
