package com.store.mcpserver.todo.dto.request;

import com.store.mcpserver.todo.enums.TodoState;

public record UpdateTodoRequest(Long id, String content, TodoState state) {

}
