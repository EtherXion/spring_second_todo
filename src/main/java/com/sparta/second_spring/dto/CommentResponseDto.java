package com.sparta.second_spring.dto;

import com.sparta.second_spring.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {

    private long id;
    private String userName;
    private String commentContent;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.userName = comment.getUserName();
        this.commentContent = comment.getCommentContent();
    }

    public CommentResponseDto(long id, String userName, String commentContent) {
        this.id = id;
        this.userName = userName;
        this.commentContent = commentContent;
    }
}
