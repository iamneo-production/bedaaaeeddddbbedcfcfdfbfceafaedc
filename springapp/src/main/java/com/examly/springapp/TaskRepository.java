package com.examly.springapp;

import com.examly.springapp.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
    
}