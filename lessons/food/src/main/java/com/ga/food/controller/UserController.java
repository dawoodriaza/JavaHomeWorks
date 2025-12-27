package com.ga.food.controller;


import com.ga.food.model.User;
import com.ga.food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/auth/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public User createdUser(@RequestBody User userObject){
        System.out.println("Calling createdUser ==>");
        return userService.createUser(userObject);
    }

}
