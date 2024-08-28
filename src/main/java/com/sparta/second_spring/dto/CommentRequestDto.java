package com.sparta.second_spring.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {

    private long id;
    private String username;
    private String commentcontent;

    private Long todoId;
}
