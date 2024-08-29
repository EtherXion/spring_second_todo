package com.sparta.second_spring.service;


import com.sparta.second_spring.dto.GetTodoResponseDto;
import com.sparta.second_spring.dto.TodoRequestDto;
import com.sparta.second_spring.dto.TodoResponseDto;
import com.sparta.second_spring.entity.Todo;
import com.sparta.second_spring.entity.Username;
import com.sparta.second_spring.repository.TodoRepository;
import com.sparta.second_spring.repository.UsertodoRepository;
import com.sparta.second_spring.repository.UsernameRepository;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UsernameRepository usernameRepository;

    public TodoService(TodoRepository todoRepository, UsertodoRepository usertodoRepository, UsernameRepository usernameRepository) {
        this.todoRepository = todoRepository;
        this.usernameRepository = usernameRepository;
    }

    // 나중에 추가하려면 id를 받아야 하나?
    @Transactional
    public TodoResponseDto createTodo(Long id , TodoRequestDto requestDto) {

        Username username = usernameRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("no user")
        );

        Todo todo = new Todo(requestDto);

        todo.setUser(username);

        Todo savedTodo = todoRepository.save(todo);

        TodoResponseDto responseDto = new TodoResponseDto(todo);

        return responseDto;

    }


    // 오류
    @Transactional
    public List<TodoResponseDto> getAllTodos() {

        List<Todo> todos;

        todos = todoRepository.findAll();

        return todos.stream().map(TodoResponseDto::new).toList();
    }

//    // 페이징 부분 오류
//    @Transactional
//    public Page<TodoResponseDto> getTodos(int page, int size){
//        Sort.Direction direction = Sort.Direction.DESC;
//        Sort sort = Sort.by(direction, "modifiedAt");
//
//        Pageable pageable = PageRequest.of(page, size, sort);
//        Page<Todo> todoList;
//
//        todoList = todoRepository.findAll(pageable);
//
//        return todoList.map(TodoResponseDto::new);
//    }

    @Transactional
    public TodoResponseDto getTodo(long id) {
        Todo todo = findTodo(id);

        return new TodoResponseDto(todo);
    }

    @Transactional
    public GetTodoResponseDto getTodoId(long id) {
        Todo todo = findTodo(id);

        return new GetTodoResponseDto(todo);
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
