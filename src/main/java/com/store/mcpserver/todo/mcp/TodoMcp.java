package com.store.mcpserver.todo.mcp;

import com.store.mcpserver.todo.dto.request.CreateTodoRequest;
import com.store.mcpserver.todo.dto.request.UpdateTodoRequest;
import com.store.mcpserver.todo.dto.response.CreateTodoResponse;
import com.store.mcpserver.todo.dto.response.GetAllTodosResponse;
import com.store.mcpserver.todo.dto.response.UpdateTodoResponse;
import com.store.mcpserver.todo.service.TodoService;
import org.apache.coyote.BadRequestException;
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

    @McpTool(description = "Edit todo")
    public UpdateTodoResponse update(@McpToolParam(description = "Update todo") UpdateTodoRequest body) throws BadRequestException {
        return service.update(body);
    }


    @McpTool(description = "Delete todo")
    public void delete(@McpToolParam(description = "id of todo task") Long id) {
        service.delete(id);
    }
}
