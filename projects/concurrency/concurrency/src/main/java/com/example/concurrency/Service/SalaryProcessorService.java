package com.example.concurrency.Service;

import com.example.concurrency.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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




}
