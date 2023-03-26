package com.itacademy.tasktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TaskTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskTestApplication.class, args);
    }
}
