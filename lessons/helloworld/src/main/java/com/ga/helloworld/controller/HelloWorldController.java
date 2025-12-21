package com.ga.helloworld.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!! This is our SPRING application.";
    }

    @GetMapping("/jdb")
    public String jdb(@RequestParam(value="name",defaultValue ="World") String name){
        return String.format("Hello %s! How are you",name);
    }

    @GetMapping("/book/{isbn}/{title}")
    public String getBook(@PathVariable("isbn") int id, @PathVariable("title")String name){
        return id + " " +name;
    }
}
