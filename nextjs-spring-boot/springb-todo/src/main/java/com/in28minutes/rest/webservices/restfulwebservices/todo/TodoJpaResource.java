package com.in28minutes.rest.webservices.restfulwebservices.todo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoJpaResource {

    private  TodoService todoService;

    private  TodoRepository todoRepository;

    TodoJpaResource(TodoService todoService , TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveAllTodos(@PathVariable String username) {
      return todoRepository.findByUsername(username);
    }

    @GetMapping("users/{username}/todos/{id}")
    public Todo retrieveTodoById(@PathVariable String username, @PathVariable int id) {
    	return todoRepository.findById((long) id).get();
    }

    @DeleteMapping("users/{username}/todos/{id}")
    public ResponseEntity<Object> deleteTodoById(@PathVariable String username, @PathVariable int id) {
    	todoRepository.deleteById((long)id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("users/{username}/todos/{id}")
    public ResponseEntity<Object> updateTodoById(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
    	todoRepository.update(todo.getDescription() , id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("users/{username}/todos")
    public Todo createTodo(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }
}
