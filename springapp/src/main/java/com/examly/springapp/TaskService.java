package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.TaskRepository;
import java.util.List;

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

    public Task getTaskById(Long taskId){
        Task task = taskRepository.findById(taskId);
    }


}
