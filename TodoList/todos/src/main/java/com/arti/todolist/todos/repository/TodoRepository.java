package com.arti.todolist.todos.repository;


import com.arti.todolist.todos.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository  extends JpaRepository<Todo, Long> {
    List<Todo> findByName(String name);
}
