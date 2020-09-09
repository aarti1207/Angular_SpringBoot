package com.arti.todolist.todos.service;

import com.arti.todolist.todos.model.Todo;
import com.arti.todolist.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getAllTodoForUser(String user) {
       return todoRepository.findByName(user);

    }

    public Todo getAllTodoForUserById(String user, Long id) {
        return todoRepository.findById(id).get();
    }

    public ResponseEntity<Void> deleteById(String user, Long id) {
         todoRepository.deleteById(id);
        System.out.println("here trying to delete");
         return ResponseEntity.noContent().build();
    }


    public ResponseEntity<Todo> updateTodo(Todo todo) {
        Todo todoUpdated = todoRepository.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);

    }

    public ResponseEntity<Void> createTodo(Todo todo) {

        Todo created = todoRepository.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
