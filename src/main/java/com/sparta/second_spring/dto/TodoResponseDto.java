package com.sparta.second_spring.dto;

import com.sparta.second_spring.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {

    private long id;
    private String userName;
    private String todoTitle;
    private String todoContent;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.userName = todo.getUsername();
        this.todoTitle = todo.getTodotitle();
        this.todoContent = todo.getTodocontent();

        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }

}


