package com.ga;

class Rectangle extends Shape {
    protected double length, height;

    public Rectangle(double length, double height){
        this.length = length;
        this.height = height;
    }

    @Override
    public double getCircumference() {
        return 2 * (length + height);
    }

    @Override
    public double getArea() {
        return length * height;
    }
}