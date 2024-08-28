package com.sparta.second_spring.service;


import com.sparta.second_spring.dto.TodoRequestDto;
import com.sparta.second_spring.dto.TodoResponseDto;
import com.sparta.second_spring.entity.Todo;
import com.sparta.second_spring.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional
    public TodoResponseDto createTodo(TodoRequestDto requestDto) {

        Todo todo = new Todo(requestDto);

        Todo savedTodo = todoRepository.save(todo);

        TodoResponseDto responseDto = new TodoResponseDto(savedTodo);

        return responseDto;

    }

    @Transactional
    public List<TodoResponseDto> getAllTodos() {



        return todoRepository.findAll().stream().map(TodoResponseDto::new).toList();
    }

    @Transactional
    public TodoResponseDto getTodo(long id) {
        Todo todo = findTodo(id);

        // 이 부분 잘 되는지 확인
        return new  TodoResponseDto(todo);
    }

    @Transactional
    public TodoResponseDto updateTodo(Long id, TodoRequestDto requestDto) {
        Todo todo = findTodo(id);

        todo.update(requestDto);

        return new TodoResponseDto(todo);
    }

    @Transactional
    public Long deleteTodo(Long id) {
        Todo todo = findTodo(id);

        todoRepository.delete(todo);

        return id;
    }


    private Todo findTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("don't find")
        );
    }

}
