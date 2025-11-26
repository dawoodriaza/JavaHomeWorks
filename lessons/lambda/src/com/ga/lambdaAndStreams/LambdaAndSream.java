package com.ga.lambdaAndStreams;

public class LambdaAndSream {
    interface Computation{
        int operation(int a, int b);
    }

    public static void main(String[] args) {

        Computation add = new Computation() {
            @Override
            public int operation(int a, int b) {
                return a+b;
            }
        };

        System.out.println("add.operation(5,6) = " + add.operation(5,6));
        
        Computation sub = new Computation() {
            @Override
            public int operation(int a, int b) {
                return a-b;
            }
        };
        System.out.println("sub.operation(5,6) = " + sub.operation(5,6));

    }
}
