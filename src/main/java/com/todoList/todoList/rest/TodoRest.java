package com.todoList.todoList.rest;

import com.todoList.todoList.dto.TodoItemDTO;
import com.todoList.todoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "http://localhost:8080")
public class TodoRest {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<TodoItemDTO> getTodoList() {
        return todoService.getAllTodoList();
    }

    @PostMapping
    public TodoItemDTO saveTodo(@RequestBody TodoItemDTO todoItem){
        return todoService.addTodoItem(todoItem);
    }

    @PutMapping("/{id}")
    public TodoItemDTO updateTodo(@PathVariable Long id, @RequestBody TodoItemDTO todoItem){
        todoItem.setId(id);
        return todoService.updateTodoItem(todoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable Long id){
        todoService.deleteTodo(id);
    }
}
