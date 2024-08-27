package com.sparta.second_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SecondSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondSpringApplication.class, args);
    }

}
