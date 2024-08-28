package com.sparta.second_spring.controller;


import com.sparta.second_spring.dto.UsernameRequestDto;
import com.sparta.second_spring.dto.UsernameResponseDto;
import com.sparta.second_spring.service.UsernameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsernameController {

    private final UsernameService usernameService;

    public UsernameController(UsernameService usernameService) {
        this.usernameService = usernameService;
    }

    @PostMapping("/users")
    public UsernameResponseDto createUser(@RequestBody UsernameRequestDto requestDto) {
        return usernameService.createUser(requestDto);
    }

    @GetMapping("/users")
    public List<UsernameResponseDto> getUsers() {
        return usernameService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UsernameResponseDto getUser(@PathVariable long id) {
        return usernameService.getUser(id);
    }

    @DeleteMapping("/users/{id}")
    public Long deleteUser(@PathVariable long id) {
        return usernameService.deleteUser(id);
    }



}
