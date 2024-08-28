package com.sparta.second_spring.entity;


import com.sparta.second_spring.dto.UsernameRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="username")
@NoArgsConstructor
public class Username extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

//    @OneToMany(mappedBy = "user")
//    private List<Todo> todo = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserTodo> usertodo = new ArrayList<>();


    public Username(UsernameRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail();
    }

    public void update(UsernameRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail();
    }

}
