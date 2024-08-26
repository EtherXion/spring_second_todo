package com.sparta.second_spring.repository;

import com.sparta.second_spring.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
//    List<Todo> findAllByOrderByModifiedAtDesc();
}
