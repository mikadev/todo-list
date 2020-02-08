package com.todo.back.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.back.entity.Task;
import com.todo.back.repository.TaskRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {this.taskRepository = taskRepository;}

    @GetMapping
    private Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    private Task saveTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
}
