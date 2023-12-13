package com.firstwebapplication.firstwebapplication.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    static {
          todos.add(new Todo(1, "in28minutes", "Learn Spring MVC", false, LocalDate.now(), false));
            todos.add(new Todo(2, "in28minutes", "Learn Struts", false, LocalDate.now(), false));
            todos.add(new Todo(3, "in28minutes", "Learn Hibernate", false, LocalDate.now(), false));
    }
    public List<Todo> retrieveTodos(String user) {
        return todos;
    }


    public void addTodo(String name, String desc, LocalDate targetDate, boolean isDone) {
        todos.add(new Todo(
                todos.size()+1, name, desc, isDone, targetDate, false
        ));
    }
}
