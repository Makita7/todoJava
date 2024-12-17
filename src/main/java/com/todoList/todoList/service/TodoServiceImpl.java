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

    public List<TodoItemDTO> getAllTodoList() {
        List<TodoItem> todoItems = todoRepository.findAll();
        //TODO map to dto
        return TodoItemMapper.MAPPER.toTodoDtoList(todoItems);
    }

    public TodoItemDTO addTodoItem(TodoItemDTO todoItemDTO){
        TodoItem todoItem = TodoItem.builder()
                .order(todoItemDTO.getOrder())
                .description(todoItemDTO.getDescription())
                .done(todoItemDTO.getDone())
                .build();
        todoRepository.save(todoItem);

        todoItemDTO.setId(todoItem.getId());
        return todoItemDTO;
    }

    public TodoItemDTO updateTodoItem(TodoItemDTO todoItemDTO){

        TodoItem todoItem = todoRepository.findById(todoItemDTO.getId()).get();
        todoItem.setDescription(todoItemDTO.getDescription());
        todoItem.setDone(todoItemDTO.getDone());
        todoItem.setOrder(todoItemDTO.getOrder());
        todoRepository.save(todoItem);

        return todoItemDTO;
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

}

