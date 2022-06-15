package com.example.soft_cons.todo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class TodoContorller {
    private final TodoRepository repository;

    TodoContorller(TodoRepository todo) {
        this.repository = todo;
    }

    @GetMapping("/todos")
    List<Todo> all() {
        return repository.findAll();
    }

    @PostMapping("/todo")
    Todo newTodo(@RequestBody Todo newTodo) {
        return repository.save(newTodo);
    }

    @GetMapping("/todo/{id}")
    Todo oneTodo(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PutMapping("/todo/{id}")
    Todo replaceTodo(@RequestBody Todo todo, @PathVariable Long id) {
        return repository.findById(id).map(to_do -> {
            to_do.setTodo(todo.getTodo());
            return repository.save(to_do);
        }).orElseGet(() -> {
            todo.setId(id);
            return repository.save(todo);
        });
    }

    @DeleteMapping("/todo/{id}")
    void deleteTodo(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
