package com.arti.todolist.todos.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {


    @GetMapping(path = "/hello-world")
    public String helloWorldDemo(){
        return "Hello World from SpringBoot";
    }
}
