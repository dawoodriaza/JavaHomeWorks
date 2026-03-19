package com.example.concurrency.Model;



import java.util.Date;

public class Employee {

    private String name;
    private double salary;
    private Date joinedDate;
    private String role;
    private double projectPercent;

    public Employee(String name, double salary, Date joinedDate, String role, double projectPercent) {
        this.name = name;
        this.salary = salary;
        this.joinedDate = joinedDate;
        this.role = role;
        this.projectPercent = projectPercent;
    }

    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Date getJoinedDate() {
        return joinedDate;
    }
    public String getRole() {
        return role;
    }
    public double getProjectPercent() {
        return projectPercent;
    }
}