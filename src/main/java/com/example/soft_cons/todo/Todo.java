package com.example.soft_cons.todo;

import javax.persistence.*;

@Entity
class Todo {
    private @Id @GeneratedValue Long id;
    private String todo_name;

    Todo() {
    }

    Todo(String todo_name) {
        this.todo_name = todo_name;
    }

    public String getTodo() {
        return this.todo_name;
    }

    public void setTodo(String todo) {
        this.todo_name = todo;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
