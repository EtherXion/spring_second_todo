package com.sparta.second_spring.service;

import com.sparta.second_spring.dto.CommentRequestDto;
import com.sparta.second_spring.dto.CommentResponseDto;
import com.sparta.second_spring.entity.Comment;
import com.sparta.second_spring.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional
    public CommentResponseDto createComment(CommentRequestDto requestDto) {

        Comment comment = new Comment(requestDto);

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
    public Long updateComment(Long id, CommentRequestDto requestDto) {
        Comment comment = findComment(id);

        comment.update(requestDto);

        return id;
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
