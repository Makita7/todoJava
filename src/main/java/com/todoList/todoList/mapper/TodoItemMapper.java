package com.todoList.todoList.mapper;

import com.todoList.todoList.dto.TodoItemDTO;
import com.todoList.todoList.model.TodoItem;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface TodoItemMapper {

    TodoItemMapper MAPPER = Mappers.getMapper(TodoItemMapper.class);

    @Mappings({
            @Mapping(target = "done", source = "doneStatus")
    })
    TodoItemDTO toTodoItem(TodoItem todoItem);
    List<TodoItem> toTodoItems(List<TodoItem> todoItemList);
    //TODO implement method from entities to dto list
    //@IterableMapping
}
