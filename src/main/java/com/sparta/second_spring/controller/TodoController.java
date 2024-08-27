package com.sparta.second_spring.controller;


import com.sparta.second_spring.dto.TodoRequestDto;
import com.sparta.second_spring.dto.TodoResponseDto;
import com.sparta.second_spring.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todo")
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto requestDto) {
        return todoService.createTodo(requestDto);
    }

    @GetMapping("/todo")
    public List<TodoResponseDto> getTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/todo/{id}")
    public List<TodoResponseDto> getTodo(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @PutMapping("/todo/{id}")
    public Long updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto requestDto) {
        return todoService.updateTodo(id, requestDto);
    }

    @DeleteMapping("/todo/{id}")
    public Long deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }



}
