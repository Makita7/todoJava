package com.todoList.todoList.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TodoItemDTO {
    private Long id;
    private int order;
    private String description;
    private Boolean done;
}
