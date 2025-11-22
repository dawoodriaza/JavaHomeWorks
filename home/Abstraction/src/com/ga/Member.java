package com.ga;

abstract class Member {
    String name;
    String feild;

    Member(String name, String feild) {
        this.name = name;
        this.feild = feild;
    }

    abstract void displayInformation();
}
