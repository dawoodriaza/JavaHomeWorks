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



    }
}