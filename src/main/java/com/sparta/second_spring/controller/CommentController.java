package com.sparta.second_spring.controller;

import com.sparta.second_spring.dto.CommentRequestDto;
import com.sparta.second_spring.dto.CommentResponseDto;
import com.sparta.second_spring.dto.TodoRequestDto;
import com.sparta.second_spring.dto.TodoResponseDto;
import com.sparta.second_spring.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }

    @GetMapping("/comments")
    public List<CommentResponseDto> getComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/comments/{id}")
    public CommentResponseDto getComment(@PathVariable Long id) {
        return commentService.getComment(id);
    }

    @PutMapping("/comments/{id}")
    public CommentResponseDto updateTodo(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(id, requestDto);
    }

    @DeleteMapping("/comments/{id}")
    public Long deleteTodo(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }


}
