package com.todoList.todoList.service;

import com.todoList.todoList.dto.TodoItemDTO;
import com.todoList.todoList.mapper.TodoItemMapper;
import com.todoList.todoList.model.TodoItem;
import com.todoList.todoList.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoItemMapper todoItemMapper;

    public List<TodoItemDTO> getAllTodoList() {
        List<TodoItem> todoItems = todoRepository.findAll();
        return todoItemMapper.toTodoItems(todoItems);
    }

    public TodoItemDTO addTodoItem(TodoItemDTO todoItemDTO){
        TodoItem todoItem = TodoItem.builder()
                .sortOrder(todoItemDTO.getSortOrder())
                .description(todoItemDTO.getDescription())
                .done(todoItemDTO.getDone())
                .build();
        todoRepository.save(todoItem);

        todoItemDTO.setId(todoItem.getId());
        return todoItemDTO;
    }

    public TodoItemDTO updateTodoItem(TodoItemDTO todoItemDTO){

        TodoItem newTodo = todoRepository.findById(todoItemDTO.getId()).get();
        newTodo.setDescription(todoItemDTO.getDescription());
        newTodo.setDone(todoItemDTO.getDone());
        newTodo.setSortOrder(todoItemDTO.getSortOrder());
        todoRepository.save(newTodo);

        return todoItemDTO;
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

}

