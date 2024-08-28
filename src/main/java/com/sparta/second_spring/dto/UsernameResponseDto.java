package com.sparta.second_spring.dto;


import com.sparta.second_spring.entity.Username;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UsernameResponseDto {

    private Long id;
    private String username;
    private String email;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public UsernameResponseDto(Username username){
        this.id = username.getId();
        this.username = username.getUsername();
        this.email = username.getEmail();

        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

}
