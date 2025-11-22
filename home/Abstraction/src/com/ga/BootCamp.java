package com.ga;
class BootCamp {
    String bootCampName;
    Instructor instructor;
    Member[] members;

    BootCamp(String bootCampName, Instructor instructor, Member[] members) {
        this.bootCampName = bootCampName;
        this.instructor = instructor;
        this.members = members;
    }

    void displayClass() {
        System.out.println("BootCamp: " + bootCampName);
        instructor.displayInformation();
        System.out.println("members:");
        for (Member m : members) {
            m.displayInformation();
        }
    }
}