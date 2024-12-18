package com.todoList.todoList.service;

import com.todoList.todoList.dto.TodoItemDTO;

import java.util.List;

public interface TodoService {
    List<TodoItemDTO> getAllTodoList();
    TodoItemDTO addTodoItem(TodoItemDTO todoItem);
    TodoItemDTO updateTodoItem(TodoItemDTO todoItemDTO);
    void deleteTodo(Long id);
}
