package com.sparta.second_spring.entity;

import com.sparta.second_spring.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "commentcontent", nullable = false, length = 500)
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;


    public Comment(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.commentContent = requestDto.getCommentcontent();
    }

    public void update(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.commentContent = requestDto.getCommentcontent();
    }


}
