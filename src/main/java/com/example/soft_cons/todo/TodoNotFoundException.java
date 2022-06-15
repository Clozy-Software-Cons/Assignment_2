package com.example.soft_cons.todo;

class TodoNotFoundException extends RuntimeException {
    TodoNotFoundException(Long id) {
        super("Could not found todo : " + id);
    }
}
