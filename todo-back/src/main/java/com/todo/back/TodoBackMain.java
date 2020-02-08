package com.todo.back;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.todo.back.entity.Task;
import com.todo.back.repository.TaskRepository;

@SpringBootApplication
public class TodoBackMain {
    public static void main(String[] args) {
        SpringApplication.run(TodoBackMain.class, args);
    }

    @Bean
    CommandLineRunner init(TaskRepository taskRepository) {
        return args -> taskRepository.save(new Task("I have to do something today"));
    }
}
