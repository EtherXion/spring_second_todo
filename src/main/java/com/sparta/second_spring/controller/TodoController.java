package com.sparta.second_spring.controller;


import com.sparta.second_spring.dto.GetTodoResponseDto;
import com.sparta.second_spring.dto.TodoRequestDto;
import com.sparta.second_spring.dto.TodoResponseDto;
import com.sparta.second_spring.entity.Todo;
import com.sparta.second_spring.service.TodoService;
import org.hibernate.query.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todos/{id}")
    public TodoResponseDto createTodo(@PathVariable Long id, @RequestBody TodoRequestDto requestDto) {
        return todoService.createTodo(id,requestDto);
    }

    @GetMapping("/todos")
    public List<TodoResponseDto> getTodos() {
        return todoService.getAllTodos();
    }

    // 페이징 부분
//    @GetMapping("/todo")
//    public Page<TodoResponseDto> getTodos(
//                               @RequestParam(value = "page", defaultValue = "0") int page,
//                               @RequestParam(value = "size", defaultValue = "10") int size) {
//        return todoService.getTodos(page, size);
//    }

    @GetMapping("/todos/{id}")
    public TodoResponseDto getTodo(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @GetMapping("/todo/{id}")
    public GetTodoResponseDto getTodoId(@PathVariable Long id) {
        return todoService.getTodoId(id);
    }

    @PutMapping("/todos/{id}")
    public TodoResponseDto updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto requestDto) {
        return todoService.updateTodo(id, requestDto);
    }

    @DeleteMapping("/todos/{id}")
    public Long deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }



}
