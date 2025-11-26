package com.ga.lambdaAndStreams;

import java.util.*;
import java.util.stream.Stream;

public class LambdaExpressionIntroDemo {
interface Computation{
    int operation (int a , int b);
}
    public static void main(String[] args) {


//        Computation add = Integer::sum; Method Reference
//        Computation add = (int a, int b)-> a+b;
//        System.out.println(add.operation(5,6));
//
//        Computation sub = (int a, int b) -> a-b;
//        System.out.println(sub.operation(5,6));


//        HelloYou hello = name -> System.out.println("Hello"+name);
//
//        hello.greetYou("Dawood Riaz");



//        List<String> stringList = Arrays.asList("Hello","Stream");
//        Stream stream = stringList.stream();
//        stringList.stream().forEach(stringValue->{
//            System.out.println(stringValue);
//        });

        List<String> stringList = Arrays.asList("Hello","Stream");
        Stream stream = stringList.stream();
        stringList.forEach(System.out::println);


    }
}
