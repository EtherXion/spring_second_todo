package com.sparta.second_spring.dto;

import com.sparta.second_spring.entity.Todo;
import lombok.Getter;

@Getter
public class TodoResponseDto {

    private long id;
    private String userName;
    private String todoTitle;
    private String todoContent;


    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.userName = todo.getUserName();
        this.todoTitle = todo.getTodoTitle();
        this.todoContent = todo.getTodoContent();
    }


    public TodoResponseDto(Long id, String userName, String todoTitle, String todoContent){
        this.id = Math.toIntExact(id);
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }


}


