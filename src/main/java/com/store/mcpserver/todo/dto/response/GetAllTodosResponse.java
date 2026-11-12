package com.store.mcpserver.todo.dto.response;

import com.store.mcpserver.todo.entity.Todo;

import java.util.List;

public record GetAllTodosResponse(List<Todo> todos) {
}
