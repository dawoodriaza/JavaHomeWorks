package com.ga.tdd;


public class Calculator {
    public static int add(final String numbers) {
        int finalValue = 0;
        String[] numbersArray = numbers.split(",");
        // removed after exception
        // if (numbersArray.length > 2) {
        // throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
        // }
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                finalValue += Integer.parseInt(number);
            }
        }
        return finalValue;
    }
}