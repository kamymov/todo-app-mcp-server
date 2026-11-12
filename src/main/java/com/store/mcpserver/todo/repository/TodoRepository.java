package com.store.mcpserver.todo.repository;

import com.store.mcpserver.todo.entity.Todo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

@Component
public class TodoRepository {

    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public List<Todo> findAll() {
        return todos;
    }

    public int findIndexById(Long id) {
        return IntStream.range(0, todos.size())
                .filter(i -> todos.get(i).getId().equals(id))
                .findFirst()
                .orElse(-1);
    }

    public Todo findById(Long id) {
        return todos.stream().filter(f->f.getId().equals(id)).findFirst().orElse(null);
    }

    public Todo create(Todo newTodo) {
        newTodo.setId(sequence.incrementAndGet());
        todos.add(newTodo);
        return newTodo;
    }

    public Todo update(Todo updatedTodo) {
        int index = findIndexById(updatedTodo.getId());
        if (index < 0) return null;
        todos.add(index, updatedTodo);
        return updatedTodo;
    }

    public void delete(Long id) {
        int index = findIndexById(id);
        if (index >= 0)
            todos.remove(index);
    }
}
