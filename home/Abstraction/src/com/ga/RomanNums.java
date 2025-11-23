package com.ga;

import java.util.*;

public class RomanNums {
    public static String intToRoman(int num) {
        Map<Integer, String> romansNumbers = new LinkedHashMap<>();
        romansNumbers.put(1000, "M");
        romansNumbers.put(900, "CM");
        romansNumbers.put(500, "D");
        romansNumbers.put(400, "CD");
        romansNumbers.put(100, "C");
        romansNumbers.put(90, "XC");
        romansNumbers.put(50, "L");
        romansNumbers.put(40, "XL");
        romansNumbers.put(10, "X");
        romansNumbers.put(9, "IX");
        romansNumbers.put(5, "V");
        romansNumbers.put(1, "I");

        String roman = "";
        List<Integer> keys = new ArrayList<>(romansNumbers.keySet());

        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            String letter = romansNumbers.get(key);
            int count = num / key;
            num = num % key;

            for (int j = 0; j < count; j++) {
                roman += letter;
            }
        }
        return roman;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}
