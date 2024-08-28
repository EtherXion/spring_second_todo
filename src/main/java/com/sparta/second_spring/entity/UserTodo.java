package com.sparta.second_spring.entity;
// 중간 테이블 @ManyToMany 없이 N:M

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="usertodo")
@NoArgsConstructor
public class UserTodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Username user;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public UserTodo(Username user, Todo todo) {
        this.user = user;
        this.todo = todo;
    }

}
