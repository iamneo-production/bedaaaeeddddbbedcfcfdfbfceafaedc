package com.examly.springapp.controller;

import java.util.List;

import com.examly.springapp.payload.TaskDto;
import com.examly.springapp.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private TaskService  taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    
    @PostMapping("/saveTask")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto){
        return new ResponseEntity<>(taskService.createTask(taskDto),HttpStatus.OK);
    }

    @GetMapping("/alltasks")
    public List<TaskDto> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/getTask")
    public ResponseEntity<?> getTaskById(@RequestParam long id){
        return new ResponseEntity<>(taskService.getTaskById(id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteTask")
    public void deleteTask(@RequestParam long id){
        taskService.deleteTask(id);
       // return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/changeStatus")
    public ResponseEntity<?> changeStatus(@RequestParam long id,@RequestBody TaskDto taskDto)
    {
        return new ResponseEntity<>(taskService.changeStatus(id,taskDto),HttpStatus.OK);
    }

}   
