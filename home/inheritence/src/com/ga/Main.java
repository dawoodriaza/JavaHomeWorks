package com.ga;

public class Main {
    public static void main(String[] args) {
        Shape triangle = new Triangle(3, 4, 5);
        Shape rectangle = new Rectangle(4, 5);

        Shape circle = new Circle(4);

        Shape square = new Square(4);

        System.out.println(getCircumferenceAndArea(triangle));
        System.out.println(getCircumferenceAndArea(rectangle));

        System.out.println(getCircumferenceAndArea(circle));

        System.out.println(getCircumferenceAndArea(square));
    }

    public static String getCircumferenceAndArea(Shape shape){
        return shape.getClass() + " circumference, area = "
                + shape.getCircumference() + "," + shape.getArea();
    }
}
