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
        Optional <Task> taskList = taskRepository.findById(taskId);
        return taskList.get();
    }

    public Task deleteTask(long taskId){
        Optional <Task> taskList = taskRepository.findById(taskId);
        Task task = taskList.get();
        taskRepository.deleteById(taskId);
        return task;
    }

    public Task updateTask(long taskId, Task task){
        Optional<Task> taskList = taskRepository.findById(taskId);
        Task t = taskList.get();
        t.setTaskId(task.getTaskId());
        t.setTaskName(task.getTaskName());
        t.setTaskDate(task.getTaskDate());
        t.setTaskHolderName(task.getTaskHolderName());
        t.setTaskStatus(task.getTaskStatus());
        taskRepository.save(t);
        return t;    
    }


}
