package com.ga;

public class Main {

    public static void main(String[] args) {
        Instructor saad = new Instructor("Mr. Saad", "Senior Software Engineer", "Full Stack");
        Student dawood = new Student("Dawood", "Software Engineer fellow", "JDPT1");


        Member[] bootCamp = {dawood};
        BootCamp bootcmaps = new BootCamp("Java Developer bootCamp", saad, bootCamp);

        saad.cohort("Java");
        dawood.cohort("Java1");


        bootcmaps.displayClass();
}}
