package com.ga.optionals;

import java.util.*;

public class Main {



    public static void main(String[] args) {
    //.epmty() method
        // .of method
        // .ofNullable


//        Optional<String> emptyOptional =Optional.empty();
//        emptyOptional =Optional.ofNullable("null");
//        System.out.println(emptyOptional.isPresent());
//        System.out.println(emptyOptional.get());

        // Checking the values in Optionals
        // isPresent();
        // ifPresent();
        // isEmpty();

//        String name = "Dawood";
//        Optional<String> optionalName =  Optional.of(name);
//        System.out.println("optionalName = " + optionalName);
//        System.out.println("optionalName = " + optionalName.isPresent());
//        Integer age = 30;
//        Optional<Integer> ageOptional = Optional.ofNullable(age);
//        
//        ageOptional.ifPresent(myage-> System.out.println("myage = " + myage));
//        System.out.println("ageOptional = " + ageOptional);

//        Optional<String> optionalValue = Optional.ofNullable(null);
//        System.out.println("optionalValue.isEmpty() = " + optionalValue.isEmpty());
//        // Getting Optional Values

        // Get()
        // orElse()
        // orElseGet()
        // orElseThrow()

        
//        String name = (String) Optional.ofNullable(null).orElse(getDefaultName());
//        System.out.println(name);}

//    String name = (String) Optional.ofNullable(null).orElseGet(()->getDefaultName());
//        String value = "Dawood";
//        String nameOptional = Optional.ofNullable(value).orElseGet(()->getDefaultName());
//        System.out.println("nameOptional = " + nameOptional);

//
//        String value = "Dawood";
//        String nameOptional = Optional.ofNullable(value).orElseThrow(()-> new IllegalArgumentException("Value is missing"));
//        System.out.println("nameOptional = " + nameOptional);

        
        /*
         * filter() 
         *
         * 
         * 
         * 
         * */

//        Optional<Integer> ageOptional = Optional.ofNullable(
//                24);
//                boolean canBuyAlcohol = ageOptional.filter(age->age>=21).isPresent();
//        System.out.println("canBuyAlcohol = " + canBuyAlcohol);

        /*
        * Map()
        * */

//Person person = new Person(25);
//boolean canAlsoBuyAlcohol = Optional.ofNullable(person).map(Person::getAge).filter(a->a>21).isPresent();
//        System.out.println("canAlsoBuyAlcohol = " + canAlsoBuyAlcohol);


        /*
        * FlatMap
        * */


        PersonWithOptionals personWithOptionals = new PersonWithOptionals(25);
        boolean abletToBuyAlcohol =  Optional.ofNullable(personWithOptionals)
                .flatMap(PersonWithOptionals::getAge).filter(a->a>=21)
                .isPresent();


        System.out.println("abletToBuyAlcohol = " + abletToBuyAlcohol);

        
                
    }
public static class PersonWithOptionals{
        private Optional<Integer> age;

        public PersonWithOptionals(int age) {
            this.age =  Optional.ofNullable(age);
        }


        public Optional<Integer> getAge() {
            return age;
        }

        public void setAge(Optional<Integer> age) {
            this.age = age;
        }


}

    public static class Person{
        private int age;

        public Person(int age){
            this.age = age;
        }
        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }



//        public static String getDefaultName(){
//            System.out.println("getDefaultName method");
//            return "World";
//        }



    }

