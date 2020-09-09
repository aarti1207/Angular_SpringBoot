package com.arti.todolist.todos.controller;


import com.arti.todolist.todos.model.Todo;
import com.arti.todolist.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Properties;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping(path="/todo/user/{user}")
    public List<Todo> getAllTodoForUSer(@PathVariable String user){
        return todoService.getAllTodoForUser(user);

    }

    @GetMapping(path="/todo/user/{user}/todos/{id}")
    public Todo getAllTodoForUserById(@PathVariable String user, @PathVariable Long id){
        return todoService.getAllTodoForUserById(user, id);

    }


    @DeleteMapping(path="/todo/user/{user}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String user, @PathVariable Long id){
        return todoService.deleteById(user, id);
    }

    @PutMapping("/todo/user/{user}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String user,
            @PathVariable long id, @RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }

    @PostMapping(path="/todo/user/{user}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String name, @RequestBody Todo todo){
        todo.setName(name);
        return  todoService.createTodo(todo);
    }


}
