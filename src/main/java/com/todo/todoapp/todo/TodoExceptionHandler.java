package com.todo.todoapp.todo;

import java.util.HashMap;
import java.util.Map;


import com.todo.todoapp.exception.TodoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TodoExceptionHandler {
    private Map<String, String> response = new HashMap<String, String>();


    @ExceptionHandler(TodoNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleTodoNotFound(TodoNotFoundException e) {
		return mountBadRequestException(e.getMessage());
    }


    private ResponseEntity<Map<String, String>> mountBadRequestException(String errorMessage){
		response.put("error", errorMessage);
		
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
	}
}