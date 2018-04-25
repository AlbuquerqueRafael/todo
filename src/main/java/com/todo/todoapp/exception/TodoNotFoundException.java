package com.todo.todoapp.exception;

public class TodoNotFoundException extends NullPointerException{
	private static final long serialVersionUID = -2378608358166304438L;

	public TodoNotFoundException(String message) {
	     super(message);
	}
}