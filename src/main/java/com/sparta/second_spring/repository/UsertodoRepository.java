package com.sparta.second_spring.repository;

import com.sparta.second_spring.entity.UserTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsertodoRepository extends JpaRepository<UserTodo, Long> {
}
