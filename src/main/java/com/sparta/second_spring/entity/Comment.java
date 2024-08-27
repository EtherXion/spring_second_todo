package com.sparta.second_spring.entity;

import com.sparta.second_spring.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comment")

@Getter
@Setter
@NoArgsConstructor

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName", nullable = false, length = 50)
    private String userName;

    @Column(name = "commentContent", nullable = false, length = 500)
    private String commentContent;



    public Comment(CommentRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.commentContent = requestDto.getCommentContent();
    }

    public void update(CommentRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.commentContent = requestDto.getCommentContent();
    }


}
