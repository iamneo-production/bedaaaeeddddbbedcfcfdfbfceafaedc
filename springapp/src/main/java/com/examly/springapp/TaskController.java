package com.examly.springapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.*;
import java.util.List;

@RestController
public class TaskController {
    
    @Autowired
    private TaskService taskService;  

    @PostMapping("/saveTask")
    public void createTask(@RequestBody Task task)  {
        taskService.createTask(task);  
    }

    @GetMapping("/alltasks")
    public List<Task> getAllTasks()  {
        return taskService.getAllTasks();
    }

    @GetMapping("/getTask")
    public Task getTaskById(@RequestParam long taskId)  {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/deleteTask")
    public Task deleteTask(@RequestParam long taskId)  {
        return taskService.deleteTask(taskId);
    }

    @GetMapping("/changeStatus")
    public Task updateTask(@RequestParam long taskId){
        return taskService.updateTask(taskId);
    }    
    
}
