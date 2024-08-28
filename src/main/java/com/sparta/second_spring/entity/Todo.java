package com.sparta.second_spring.entity;

import com.sparta.second_spring.dto.TodoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="todo")
@NoArgsConstructor
public class Todo extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false, length = 50)
    private String userName;
    @Column(name = "todotitle", nullable = false, length = 500)
    private String todoTitle;
    @Column(name = "todocontent", nullable = false, length = 500)
    private String todoContent;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    // orphanRemoval = true 참조 끊긴 자식 엔티티 삭제 영속성 전이
    private List<Comment> comments;

    @OneToMany(mappedBy = "todo")
    private List<UserTodo> usertodo = new ArrayList<>();



    public Todo(TodoRequestDto requestDto) {
        this.userName = requestDto.getUsername();
        this.todoTitle = requestDto.getTodoTitle();
        this.todoContent = requestDto.getTodoContent();
    }

    public void update(TodoRequestDto requestDto) {
        this.userName = requestDto.getUsername();
        this.todoTitle = requestDto.getTodoTitle();
        this.todoContent = requestDto.getTodoContent();
    }



}
