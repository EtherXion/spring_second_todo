package com.sparta.second_spring.service;


import com.sparta.second_spring.dto.TodoRequestDto;
import com.sparta.second_spring.dto.TodoResponseDto;
import com.sparta.second_spring.entity.Todo;
import com.sparta.second_spring.repository.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto create(TodoRequestDto requestDto) {

        Todo todo = new Todo(requestDto);

        Todo savedTodo = todoRepository.save(todo);

        TodoResponseDto responseDto = new TodoResponseDto(savedTodo);

        return responseDto;

    }




}
