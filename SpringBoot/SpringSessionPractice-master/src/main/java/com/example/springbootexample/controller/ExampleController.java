package com.example.springbootexample.controller;

import com.example.springbootexample.model.User;
import com.example.springbootexample.service.GreetinfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExampleController {
    @Autowired
    private GreetinfService greetinfService;

    @Autowired
    public ExampleController(GreetinfService greetinfService) {
        this.greetinfService = greetinfService;
    }

    //    @Autowired
//    public void setGreetinfService(GreetinfService greetinfService) {
//        this.greetinfService = greetinfService;
//        this.greetinfService.setMessage("Hello");
//    }

    @RequestMapping(value = "/message/{name}", method = RequestMethod.GET)
    public String message(@PathVariable String name){
        return greetinfService.greet(name);
    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping
    public String messageParam(@RequestParam String fName,@RequestParam String lName){
        return greetinfService.greet1(fName,lName);
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
    @PostMapping
    public String requestBodyExample(@RequestBody User user) {
        return greetinfService.greetUser(user);
    }

}
