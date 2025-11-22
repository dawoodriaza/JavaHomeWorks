package com.ga;

class Instructor extends Member implements GeneralAssembly {
    String subject;

    Instructor(String name, String feild, String subject) {
        super(name, feild);
        this.subject = subject;
    }

    @Override
    void displayInformation() {
        System.out.println("Teacher: " + name + ", Field: " + feild + ", Subject: " + subject);
    }
    @Override
    public void cohort(String cohortName) {
        System.out.println(name + " is instrcutor of: " + cohortName);
    }

}