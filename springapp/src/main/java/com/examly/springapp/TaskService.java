package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.TaskRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public void createTask(Task task){
        taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        List<Task> list = taskRepository.findAll();
        return list;
    }    

    public Task getTaskById(long taskId){
        Optional <task> list = taskRepository.findById(taskId);
        return task;
    }

    public Task deleteTask(long taskId){
        Task task = taskRepository.findById(id)
    }


}
