package com.ga.lambdaAndStreams;


import java.util.*;
import java.util.stream.Collectors;

public class IndependentPractice{

    public static void main(String[] args) {
        List<Person> personList = createPersonList();

//        //TODO: Create a List of Person Objects whose name starts with the letter M
//        List<Person> personsThatNameStartWithM = personList.stream()
//                .filter(p -> p.getName().startsWith("M"))
//                .toList();
//
//        personsThatNameStartWithM.forEach(System.out::println);
//
//        //TODO: Create a List of Strings containing the names of the Persons over the age of 40
//        List<String> namesOfPersonsOverAgeOfForty = personList.stream()
//                .filter(p -> p.getAge() > 40)
//                .map(Person::getName)
//                .toList();
//
//        namesOfPersonsOverAgeOfForty.forEach(System.out::println);
//
//        //TODO: Create a List of Person Objects whose name starts with the letter J and are under the age of 47
//        List<Person> personsWithJNameAndUnderFortySeven= personList.stream()
//                .filter(p -> p.getName().startsWith("J") && p.getAge() < 47)
//                .toList();
//
//        personsWithJNameAndUnderFortySeven.forEach(System.out::println);

//        List<Person> personList1 = Arrays.asList(
//                new Person("Tom",30),
//                new Person("Jeff",70)
//
//                );
//
//        List<Person> personList2 = Arrays.asList(
//                new Person("Dawood",26),
//                new Person("Shahid",28)
//
//        );
//
//        List<List<Person>> listOfPersonList = Arrays.asList(personList1,personList2);
//        System.out.println("listOfPersonList"+listOfPersonList );
//
//        List <Person> flatPersonList = listOfPersonList.stream().flatMap(Collection::stream).toList();
//
//        System.out.println(flatPersonList);
//
////        flatPersonList.forEach(person -> System.out.println(person));
//
//        flatPersonList.forEach(System.out::println);

// sorted: sort the person list alphabetically
//        List<Person> sortedList =
//                personList.stream()
//                        .sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
//                        .collect(Collectors.toList());


//        List<Person> sortedList =
//                personList.stream()
//                        .sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
//                        .toList();



//        List<Person> sortedList =
//                personList.stream()
//                        .sorted(Comparator.comparing(Person::getAge)).filter(person -> Person("Henry"));
//                        .toList();

//        List<Person> sortedList =
//                personList.stream()
//                        .filter( p -> p.getAge()>32)
//                        .filter(p -> p.getName().startsWith("J"))
//                        .sorted(Comparator.comparing(Person::getAge))
//                        .toList();


//        Person personOverThirtyFive = personList.stream()
//                .filter(p-> p.getAge()>135)
//                .findFirst()
//                .orElse(null);
//
//
//        System.out.println("personOverThirtyFive = " + personOverThirtyFive);
//        sortedList.forEach(person -> System.out.println(person));
//                sortedList.forEach(System.out::println);

        // TOSEt()


//        List <Person> duplicatePersonList =
//
//        Set<Person> personSet = personList
//                .stream()
//                .collect(Collectors.toSet());
//        System.out.println("personSet = " + personSet);



        //toMap()

//        Map<String,Integer> nameToAge = personList.stream().collect(Collectors.toMap(p-> p.getName(),p->p.getAge()));

//        Map<String,Integer> nameToAge = personList.stream().collect(Collectors.toMap(Person::getName, Person::getAge));


        Map<Integer,String> nameToAge = personList.stream().collect(Collectors.toMap(Person::getAge, Person::getName));
//Key cannot be duplicate
        nameToAge.forEach((Key,value) -> System.out.println("Key is = " + Key + " name is " + value));
    }

    private static List<Person> createPersonList() {
        return Arrays.asList(
                new Person("Mark", 45),
                new Person("Henry", 30),
                new Person("John", 18),
                new Person("Morgan", 6),
                new Person("Saad", 20),
                new Person("Tiffany", 60),
                new Person("Jim", 50),
                new Person("Janet", 152)

        );
    }
}