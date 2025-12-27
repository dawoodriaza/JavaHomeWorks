package com.ga.todoapp.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String hello(){
        System.out.println("Calling Get Hello Word Api");
        return "Hello World";
    }
}




