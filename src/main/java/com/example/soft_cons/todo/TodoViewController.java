package com.example.soft_cons.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoViewController {

    private final TodoRepository repository;

    TodoViewController(TodoRepository todo) {
        this.repository = todo;
    }

    @GetMapping("/view/todo/{id}")
    public ModelAndView view_todo(@PathVariable Long id) {
        Todo todo = repository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));

        ModelAndView mnv = new ModelAndView();
        mnv.setViewName("todo/todo");
        mnv.addObject("todo", todo);
        mnv.addObject("id", id);

        return mnv;
    }
}
