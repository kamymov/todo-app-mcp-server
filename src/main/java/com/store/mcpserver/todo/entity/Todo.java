package com.store.mcpserver.todo.entity;

import com.store.mcpserver.todo.enums.TodoState;

public class Todo {

    private Long id;
    private String content;
    private TodoState state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TodoState getState() {
        return state;
    }

    public void setState(TodoState state) {
        this.state = state;
    }

    public Todo(Long id, String content, TodoState state) {
        this.id = id;
        this.content = content;
        this.state = state;
    }

    public Todo(String content, TodoState state) {
        this.content = content;
        this.state = state;
    }
}
