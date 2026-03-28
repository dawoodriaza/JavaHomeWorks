package com.example.concurrency.Service;

import com.example.concurrency.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class SalaryProcessorService {

    private final Semaphore semaphore = new Semaphore(3);
    private final Lock lock = new ReentrantLock();

    public void processAll(List<Employee> employees) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (Employee emp : employees) {
            executor.submit(() -> processEmployee(emp));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processEmployee(Employee emp) {
        try {
            semaphore.acquire();

            if (emp.getProjectPercent() < 60) {
                System.out.println(emp.getName() + " skipped (below 60%)");
                return;
            }

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

            lock.lock();
            try {
                emp.setSalary(newSalary);
            } finally {
                lock.unlock();
            }

            System.out.println(emp.getName() + " processed by " + Thread.currentThread().getName()
                    + " | New Salary: " + String.format("%.2f", emp.getSalary()));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}