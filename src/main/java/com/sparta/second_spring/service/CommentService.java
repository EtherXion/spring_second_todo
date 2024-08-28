package com.sparta.second_spring.service;

import com.sparta.second_spring.dto.CommentRequestDto;
import com.sparta.second_spring.dto.CommentResponseDto;
import com.sparta.second_spring.entity.Comment;
import com.sparta.second_spring.entity.Todo;
import com.sparta.second_spring.repository.CommentRepository;
import com.sparta.second_spring.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository; // 이걸 받아서 하는게 맞나 나중에 확인

    public CommentService(CommentRepository commentRepository , TodoRepository todoRepository) {
        this.commentRepository = commentRepository;
        this.todoRepository = todoRepository;
    }

    @Transactional
    public CommentResponseDto createComment(CommentRequestDto requestDto) {

        Todo todo = todoRepository.findById(requestDto.getTodoId()).orElseThrow(() ->
                new IllegalArgumentException("no todo")
        );

        Comment comment = new Comment(requestDto);

        comment.setTodo(todo); // 외래키 설정

        Comment savedComment = commentRepository.save(comment);

        CommentResponseDto responseDto = new CommentResponseDto(savedComment);

        return responseDto;

    }

    @Transactional
    public List<CommentResponseDto> getAllComments() {

        return commentRepository.findAll().stream().map(CommentResponseDto::new).toList();
    }

    @Transactional
    public CommentResponseDto getComment(Long id) {
        Comment comment = findComment(id);

        return new CommentResponseDto(comment);
    }

    @Transactional
    public CommentResponseDto updateComment(Long id , CommentRequestDto requestDto) {
        Comment comment = findComment(id);

        comment.update(requestDto);

        return new CommentResponseDto(comment);
    }

    @Transactional
    public Long deleteComment(Long id) {
        Comment comment = findComment(id);

        commentRepository.delete(comment);

        return id;
    }


    private Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("no comment")
        );
    }

}
