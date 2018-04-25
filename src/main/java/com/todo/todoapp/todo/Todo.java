package com.todo.todoapp.todo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Entity
@Table (name = "todo")
public class Todo implements Serializable {

    private static final long serialVersionUID = -1785131699037567362L;

	@Id
	@GeneratedValue
    private Long id;
    
	@Column(nullable = false)
	private boolean isDone;

    @Column(nullable = false)
    private String text;

	protected Todo () {
	}

	public Todo (boolean isDone, String text) {
        this.isDone = isDone;
        this.text = text;
	}

	public boolean getIsDone () {
		return this.isDone;
    }
    
    public Long getID () {
		return this.id;
    }
    
    public String getText () {
        return this.text;
    }

    public void setIsDone (boolean isDone) {
		this.isDone = isDone;
    }

    public void setText (String text) {
		this.text = text;
    }

}