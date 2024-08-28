package com.sparta.second_spring.controller;


import com.sparta.second_spring.dto.UsernameRequestDto;
import com.sparta.second_spring.dto.UsernameResponseDto;
import com.sparta.second_spring.service.UsernameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsernameController {

    private final UsernameService usernameService;

    public UsernameController(UsernameService usernameService) {
        this.usernameService = usernameService;
    }

    @PostMapping("/users")
    public UsernameResponseDto createTodo(@RequestBody UsernameRequestDto requestDto) {
        return usernameService.createTodo(requestDto);
    }




}
