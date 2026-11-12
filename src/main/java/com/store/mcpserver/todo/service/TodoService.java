package com.store.mcpserver.todo.service;

import com.store.mcpserver.todo.dto.request.CreateTodoRequest;
import com.store.mcpserver.todo.dto.request.UpdateTodoRequest;
import com.store.mcpserver.todo.dto.response.CreateTodoResponse;
import com.store.mcpserver.todo.dto.response.GetAllTodosResponse;
import com.store.mcpserver.todo.dto.response.UpdateTodoResponse;
import com.store.mcpserver.todo.entity.Todo;
import com.store.mcpserver.todo.repository.TodoRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public GetAllTodosResponse getAll() {
        return new GetAllTodosResponse(repository.findAll());
    }

    public CreateTodoResponse create(CreateTodoRequest body) {
        Todo newTodo = repository.create(
                new Todo(body.content(), body.state())
        );
        return new CreateTodoResponse(newTodo);
    }

    public UpdateTodoResponse update(UpdateTodoRequest body) throws BadRequestException {
        Todo todo = repository.findById(body.id());
        if (todo == null) throw new BadRequestException("Todo Not Found");
        todo.setContent(body.content());
        todo.setState(body.state());
        Todo updatedTodo = repository.update(todo);
        return new UpdateTodoResponse(updatedTodo);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
