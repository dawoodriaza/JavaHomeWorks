package com.ga.lambdaAndStreams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnotherPersonClass {

    public static void main(String[] args) {

        List<AnotherPerson> largePersonList = Arrays.asList(
                new AnotherPerson("Tom", "Male", 30, 50000),
                new AnotherPerson("John", "Male", 30, 60000),
                new AnotherPerson("Jenny", "Female",  20, 70000),
                new AnotherPerson("Mark", "Male", 35, 30000),
                new AnotherPerson("Chris", "Male", 37, 20000),
                new AnotherPerson("Paige", "Female",  31, 25000),
                new AnotherPerson("Helen", "Female",  60, 100000),
                new AnotherPerson("Erin", "Female",  50, 500000),
                new AnotherPerson("Zach", "Male", 10, 1000),
                new AnotherPerson("Jane", "Female",  45, 200000),
                new AnotherPerson("Jeff", "Male", 70, 80000)
        );

        // TODO: Find the person with the highest salary.


        AnotherPerson name =  largePersonList.stream().max(Comparator.comparing(AnotherPerson::getSalary)).orElse(null);
        AnotherPerson names =  largePersonList.stream().max(Comparator.comparing(AnotherPerson::getSalary)).orElse(null);

//        int names =  largePersonList.stream().mapToInt(AnotherPerson::getSalary).min().orElse(0);
        System.out.println("name = " + names);




        // TODO: Find the person with the lowest salary.
        AnotherPerson name2 =  largePersonList.stream().min(Comparator.comparing(AnotherPerson::getSalary)).orElse(null);

        System.out.println("name = " + name2);
        // TODO: Create a map where the key is age and the value is the name of the person. For any duplicate keys, use
        // the first entry and ignore any duplicates.

        Map<Integer, String> Duplicate = largePersonList.stream()
                .collect(Collectors.toMap(AnotherPerson::getAge, AnotherPerson::getName
                        ,(first, second) -> first));

        System.out.println("Duplicate = " + Duplicate);

        // Bonus TODO: Create a map where the key is the gender and the value is a list of Persons(hint: groupingBy()). Filter the results to only
        // include persons over the age of 30 who have a salary greater than 20,000.


        Map<String, List<AnotherPerson>> Duplicates = largePersonList.stream().filter(anotherPerson -> anotherPerson.getAge()>30 && anotherPerson.getSalary()>20000)
                .collect(Collectors.groupingBy(
                        AnotherPerson::getGender
                ));

        System.out.println("Duplicates = " + Duplicates);
    }



}
