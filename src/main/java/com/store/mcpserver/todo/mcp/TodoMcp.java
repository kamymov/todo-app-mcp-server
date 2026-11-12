package com.store.mcpserver.todo.mcp;

import com.store.mcpserver.todo.dto.request.CreateTodoRequest;
import com.store.mcpserver.todo.dto.response.CreateTodoResponse;
import com.store.mcpserver.todo.dto.response.GetAllTodosResponse;
import com.store.mcpserver.todo.service.TodoService;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

@Component
public class TodoMcp {

    private final TodoService service;

    public TodoMcp(TodoService service) {
        this.service = service;
    }

    @McpTool(description = "Get All Todos list")
    public GetAllTodosResponse getAll() {
        return service.getAll();
    }

    @McpTool(description = "Add new todo")
    public CreateTodoResponse create(@McpToolParam(description = "Create new Todo parameter") CreateTodoRequest body) {
        return service.create(body);
    }
}
