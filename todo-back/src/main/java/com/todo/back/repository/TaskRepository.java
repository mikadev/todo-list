package com.todo.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todo.back.entity.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
