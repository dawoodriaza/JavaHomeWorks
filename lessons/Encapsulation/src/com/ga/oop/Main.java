package com.ga.oop;

import java.util.Stack;

public class Main {
final int x= 10;
String fname= "Saad";
String Lname = "Iqbal";
int age =35;

// As it is static it belongs to the class so anyone can call it in the package
static  void myStaticMethod(){
    System.out.println("Static Method");
}

// As it is public and not public we can call  it from obj can use this method in the same package
public void PublicMethod(){
    System.out.println("Public Method");
}


    public static void main(String[] args) {
Main obj= new Main();
    myStaticMethod();
    obj.PublicMethod();


//        Main myObj1 = new Main();
//        System.out.println(myObj1.x);
//        Main myObj2 = new Main();
//        System.out.println("myObj2 = " + myObj2.x);

//        System.out.println("Name "+ obj.fname);
//        System.out.println("Lname" + obj.Lname);
//        System.out.println("age" + obj.age);



    }
}