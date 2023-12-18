package com.in28minutes.rest.webservices.restfulwebservices.todo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private  TodoService todoService;

    TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveAllTodos(@PathVariable String username) {
      return todoService.findByUsername(username);
    }

    @GetMapping("users/{username}/todos/{id}")
    public Todo retrieveTodoById(@PathVariable String username, @PathVariable int id) {
    	return todoService.findById(id);
    }

    @DeleteMapping("users/{username}/todos/{id}")
    public ResponseEntity<Object> deleteTodoById(@PathVariable String username, @PathVariable int id) {
    	todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("users/{username}/todos/{id}")
    public ResponseEntity<Object> updateTodoById(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
    	todoService.updateTodo(todo.getDescription() , id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("users/{username}/todos")
    public Todo createTodo(@RequestBody Todo description){
        System.out.println(description);
        return todoService.createTodo(description.getDescription());
    }
}
