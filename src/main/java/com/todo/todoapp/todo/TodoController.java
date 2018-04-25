package com.todo.todoapp.todo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value = "/api")
public class TodoController {
	
    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
	public List<Todo> getAll () {
		return todoService.getAll();
    }
    
    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> save (@RequestBody Todo todo) {
        Map<String, String> response = todoService.save(todo);

		return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/todo/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, String>> update (@PathVariable("id") Long id,
                                                       @RequestBody Todo todo) {
        Map<String, String> response = todoService.update(todo, id);

        return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
    }	
    
    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, String>> delete (@PathVariable("id") Long id) {
        Map<String, String> response = todoService.delete(id);

		return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
	}	
	
}