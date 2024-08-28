package com.sparta.second_spring.dto;


import com.sparta.second_spring.entity.Username;
import lombok.Getter;

@Getter
public class UsernameResponseDto {

    private Long id;
    private String username;
    private String email;

    public UsernameResponseDto(Username username){
        this.id = username.getId();
        this.username = username.getUsername();
        this.email = username.getEmail();
    }

    public UsernameResponseDto(Long id, String username, String email){
        this.id = id;
        this.username = username;
        this.email = email;
    }


}
