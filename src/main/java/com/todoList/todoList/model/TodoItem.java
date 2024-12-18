package com.todoList.todoList.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "TODO_ITEM")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoItem {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private int sortOrder;
    private String description;
    private Boolean done;
}
