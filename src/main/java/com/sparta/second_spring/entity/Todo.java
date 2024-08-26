package com.sparta.second_spring.entity;

import com.sparta.second_spring.dto.TodoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Todo")

@Getter
@Setter
@NoArgsConstructor

public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "userName", nullable = false, length = 500)
    private String userName;
    @Column(name = "todoTitle", nullable = false, length = 500)
    private String todoTitle;
    @Column(name = "todoContent", nullable = false, length = 500)
    private String todoContent;


    public Todo(TodoRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.todoTitle = requestDto.getTodoTitle();
        this.todoContent = requestDto.getTodoContent();
    }

    public void update(TodoRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.todoTitle = requestDto.getTodoTitle();
        this.todoContent = requestDto.getTodoContent();
    }



}
