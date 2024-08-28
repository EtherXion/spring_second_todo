package com.sparta.second_spring.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {

    private long id;
    private String userName;
    private String commentContent;
}
