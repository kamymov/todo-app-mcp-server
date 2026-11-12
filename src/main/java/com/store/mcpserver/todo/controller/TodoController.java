package com.store.mcpserver.todo.controller;

import com.store.mcpserver.todo.dto.request.CreateTodoRequest;
import com.store.mcpserver.todo.dto.request.UpdateTodoRequest;
import com.store.mcpserver.todo.dto.response.CreateTodoResponse;
import com.store.mcpserver.todo.dto.response.GetAllTodosResponse;
import com.store.mcpserver.todo.dto.response.UpdateTodoResponse;
import com.store.mcpserver.todo.service.TodoService;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

@RestController("todo")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping()
    public GetAllTodosResponse getAll() {
        return service.getAll();
    }

    @PostMapping()
    public CreateTodoResponse create(@RequestBody CreateTodoRequest body) {
        return service.create(body);
    }

    @PutMapping()
    public UpdateTodoResponse update(@RequestBody UpdateTodoRequest body) throws BadRequestException {
        return service.update(body);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
