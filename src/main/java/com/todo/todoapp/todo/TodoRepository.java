package com.todo.todoapp.todo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}