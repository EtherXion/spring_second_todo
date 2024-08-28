package com.sparta.second_spring.dto;

import com.sparta.second_spring.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private long id;
    private String userName;
    private String commentContent;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.userName = comment.getUsername();
        this.commentContent = comment.getCommentContent();

        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }

}
