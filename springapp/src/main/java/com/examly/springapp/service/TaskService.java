package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.payload.TaskDto;


public interface TaskService {
    TaskDto createTask(TaskDto taskDto);
    List<TaskDto> getAllTasks();
    void deleteTask(long id);

    TaskDto getTaskById(long taskId);
}