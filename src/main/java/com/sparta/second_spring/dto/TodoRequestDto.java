package com.sparta.second_spring.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {

    private long id;
    private String userName;
    private String todoTitle;
    public String todoContent;

}
