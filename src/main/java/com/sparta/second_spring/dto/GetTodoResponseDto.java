package com.sparta.second_spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.second_spring.entity.Todo;
import com.sparta.second_spring.entity.Username;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetTodoResponseDto {

    private long id;
    private String userName;
    private String todoTitle;
    private String todoContent;

    private int commentCount; // 댓글 개수

    private long usernameId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modifiedAt;


    public GetTodoResponseDto(Todo todo) {

        this.id = todo.getId();
        this.userName = todo.getUserName();
        this.todoTitle = todo.getTodoTitle();
        this.todoContent = todo.getTodoContent();

        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();

        this.usernameId = todo.getUser().getId();

//        this.commentCount = todo.getComments().size(); // 댓글 개수

    }

    @Getter
    public static class GetTodoUserDto {
        private long id;
        private String userName;
        private String email;

        public GetTodoUserDto(Username user) {
            this.id = user.getId();
            this.userName = user.getUsername();
            this.email = user.getEmail();
        }

    }



}
