package com.firstwebapplication.firstwebapplication.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    @ResponseBody
    public List<Todo> listAllTodos() {
        List<Todo> todos = todoService.retrieveTodos("in28minutes");
        return todos;
    }

    @RequestMapping(value = "/add-todos" ,method = RequestMethod.GET)
    public String showAddTodo() {
        return "add-todo";
    }
    @RequestMapping(value = "/add-todos" ,method = RequestMethod.POST)
    public String addTodo(@RequestParam String desc , ModelMap model) {
        todoService.addTodo("in28minutes",desc, LocalDate.now(),false);
        return "redirect:/list-todos";
    }


}
