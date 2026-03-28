package com.example.concurrency;

import com.example.concurrency.Model.Employee;
import com.example.concurrency.Service.CsvService;
import com.example.concurrency.Service.SalaryProcessorService;

import java.util.List;

public class ConcurrencyApplication {

    public static void main(String[] args) {

        CsvService csvService = new CsvService();
        SalaryProcessorService processorService = new SalaryProcessorService();

        String path = "employees.csv";

        List<Employee> employees = csvService.readCsv(path);

        System.out.println("-----------------------------------------------");
        for (Employee e : employees) {
            System.out.println(e.getName() + " -> " + e.getSalary());
        }

        processorService.processAll(employees);

        System.out.println("-------------------------------------------");
        for (Employee e : employees) {
            System.out.println(e.getName() + " -> " + String.format("%.2f", e.getSalary()));
        }
    }
}