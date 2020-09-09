package com.arti.todolist.todos.controller;

import com.arti.todolist.todos.service.TodoService;
import com.arti.todolist.todos.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping(path="/todo/{user}/userLogin/{password}")
    public boolean isValidUser(@PathVariable  String user,@PathVariable String password){

        
    }

}
