package com.example.concurrency.Service;


import com.example.concurrency.Model.Employee;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CsvService {
    public List<Employee> readCsv(String path) {
        List<Employee> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;
            br.readLine();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Date joinedDate = sdf.parse(data[2]);

                Employee emp = new Employee(
                        data[0],
                        Double.parseDouble(data[1]),
                        joinedDate,
                        data[3],
                        Double.parseDouble(data[4])
                );

                list.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}