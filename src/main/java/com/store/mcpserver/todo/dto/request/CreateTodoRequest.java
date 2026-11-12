package com.store.mcpserver.todo.dto.request;

import com.store.mcpserver.todo.enums.TodoState;

public record CreateTodoRequest (String content, TodoState state) {}