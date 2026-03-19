package com.example.concurrency;

import com.example.concurrency.Model.Employee;
import com.example.concurrency.Service.CsvService;

import java.util.List;

public class ConcurrencyApplication {

    public static void main(String[] args) {

        CsvService csvService = new CsvService();
        String path = "employees.csv";

        List<Employee> employees = csvService.readCsv(path);

        for (Employee e : employees) {
            System.out.println(e.getName() + " -> " + e.getSalary());
        }

        Thread[] threads = new Thread[employees.size()];

        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);

            threads[i] = new Thread(() -> processEmployee(emp));
            threads[i].start();
        }


        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        for (Employee e : employees) {
            System.out.println(e.getName() + " -> " + e.getSalary());
        }
    }


    private static void processEmployee(Employee emp) {


        if (emp.getProjectPercent() < 60) return;

        double increase = 0;


        switch (emp.getRole().toLowerCase()) {
            case "director":
                increase += 5;
                break;
            case "manager":
                increase += 2;
                break;
            default:
                increase += 1;
        }


        long years = (System.currentTimeMillis() - emp.getJoinedDate().getTime())
                / (1000L * 60 * 60 * 24 * 365);

        if (years >= 1) {
            increase += years * 2;
        }


        if (emp.getProjectPercent() > 80) {
            increase = increase * 1.5;
        }

        double newSalary = emp.getSalary() + (emp.getSalary() * increase / 100);

        synchronized (emp) {
            emp.setSalary(newSalary);
        }

        System.out.println(emp.getName() + " processed by " + Thread.currentThread().getName());

    }
}