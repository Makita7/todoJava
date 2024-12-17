package com.todoList.todoList.mapper;

import com.todoList.todoList.dto.TodoItemDTO;
import com.todoList.todoList.model.TodoItem;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoItemMapper {

    @Mappings({
            @Mapping(target = "done", source = "doneStatus")
    })
    TodoItemDTO toTodoItem(TodoItem todoItem);
    List<TodoItemDTO> toTodoItems(List<TodoItem> todoItemList);
}
