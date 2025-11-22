package com.ga;

class Student extends Member implements GeneralAssembly {
    String cohortName;

    Student(String name, String feild, String cohortName) {
        super(name, feild);
        this.cohortName = cohortName;
    }

    @Override
    void displayInformation() {
        System.out.println("Student: " + name + ", Field: " + feild + ", Cohort Name: " + cohortName);
    }

    @Override
    public void cohort(String cohortName) {
        System.out.println(name + " joined cohort: " + cohortName);
    }


}