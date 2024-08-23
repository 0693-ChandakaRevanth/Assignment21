package com.example.springbootexample.service;

import com.example.springbootexample.model.User;
import org.springframework.stereotype.Service;

@Service
public class GreetinfService {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String greet(String name){
        return message+ ", "+name;
    }

    public String greet1(String fName, String lName) {
        return message+ ", "+fName+ " " +lName;
    }

    public String greetUser(User user) {
        return message+ "," +user.getName()+" " +user.getSalary();
    }
}
