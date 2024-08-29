package com.sparta.second_spring.service;


import com.sparta.second_spring.dto.UsernameRequestDto;
import com.sparta.second_spring.dto.UsernameResponseDto;
import com.sparta.second_spring.entity.Todo;
import com.sparta.second_spring.entity.UserTodo;
import com.sparta.second_spring.entity.Username;
import com.sparta.second_spring.repository.TodoRepository;
import com.sparta.second_spring.repository.UsernameRepository;
import com.sparta.second_spring.repository.UsertodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class UsernameService {

    private final UsernameRepository usernameRepository;
    private final TodoRepository todoRepository;
    private final UsertodoRepository usertodoRepository;

    public UsernameService(UsernameRepository usernameRepository, TodoRepository todoRepository, UsertodoRepository usertodoRepository) {
        this.usernameRepository = usernameRepository;
        this.todoRepository = todoRepository;
        this.usertodoRepository = usertodoRepository;
    }

    @Transactional
    public UsernameResponseDto createUser(UsernameRequestDto requestDto) {

        Username username = new Username(requestDto);

        Username saveUsername = usernameRepository.save(username);

        UsernameResponseDto usernameResponseDto = new UsernameResponseDto(saveUsername);

        return usernameResponseDto;
    }

    @Transactional
    public List<UsernameResponseDto> getAllUsers() {
        return usernameRepository.findAll().stream().map(UsernameResponseDto::new).toList();
    }

    @Transactional
    public UsernameResponseDto getUser(long id) {
        Username username = findUser(id);

        return new UsernameResponseDto(username);
    }

    @Transactional
    public Long updateUser(long id, Long todoId , Long userId) {
        Username username = findUser(userId);
        Todo todo = findTodo(todoId);

        if (!Objects.equals(id, todo.getUser().getId())){
            throw new IllegalArgumentException("not same user");
        } // 같아야 추가 가능이니까

        UserTodo userTodo = new UserTodo();
        userTodo.setTodo(todo);
        userTodo.setUser(username);

        usertodoRepository.save(userTodo);

        return id;
    }

    @Transactional
    public Long deleteUser(long id) {
        Username username = findUser(id);

        usernameRepository.delete(username);

        return id;
    }





    private Username findUser(long id) {
        return usernameRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("no user")
        );
    }

    private Todo findTodo(long id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("no todo"));
    }

}
