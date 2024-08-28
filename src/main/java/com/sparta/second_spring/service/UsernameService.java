package com.sparta.second_spring.service;


import com.sparta.second_spring.dto.UsernameRequestDto;
import com.sparta.second_spring.dto.UsernameResponseDto;
import com.sparta.second_spring.entity.Username;
import com.sparta.second_spring.repository.UsernameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsernameService {

    private final UsernameRepository usernameRepository;

    public UsernameService(UsernameRepository usernameRepository) {
        this.usernameRepository = usernameRepository;
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
    public Long updateUser(long id, UsernameRequestDto requestDto) {
        Username username = findUser(id);

        username.update(requestDto);

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

}
