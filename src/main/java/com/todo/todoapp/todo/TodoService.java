package com.todo.todoapp.todo;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

import com.todo.todoapp.exception.TodoNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
    private Map<String, String> response = new HashMap<String, String>();
    
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }
    
	public Map<String, String> save (Todo todo){
        todoRepository.save(todo);

        response.put("response", "Todo was successfully persisted");
        return response;
    }
    
    public  Map<String, String> update (Todo todo, Long id) {
        Optional<Todo> optTodo = todoRepository.findById(id);

        if (!optTodo.isPresent()) {
            throw new TodoNotFoundException("Todo don't exists");
        }

        Todo auxTodo = optTodo.get();
        auxTodo.setText(todo.getText());
        auxTodo.setIsDone(todo.getIsDone());

        todoRepository.save(auxTodo);

        response.put("response", "Todo was successfully updated");
        return response;
    }
	
	public Map<String, String> delete(Long id){
        Optional<Todo> optTodo = todoRepository.findById(id);
  
        if (!optTodo.isPresent()) {
            throw new TodoNotFoundException("Todo don't exists");
        }

        Todo todo = optTodo.get();
        todoRepository.delete(todo);

        response.put("response", "Todo was successfully deleted");
		return response;
	}
	
	
	
}