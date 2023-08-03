package com.examly.springapp.controller;

import java.util.List;

import com.examly.springapp.payload.TaskDto;
import com.examly.springapp.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<TaskDto> getTaskById(@RequestParam long id){
        return new ResponseEntity<>(taskService.getTaskById(id),HttpStatus.OK);
    }


    @GetMapping("/deleteTask")
    public ResponseEntity<String> deleteTask(@RequestParam long id){
        taskService.deleteTask(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
    
    @GetMapping("/changeStatus")
    public ResponseEntity<String> changeStatus(@RequestParam long id,@RequestBody TaskDto taskDto)
    {
        taskService.changeStatus(id,taskDto);
        return new
    }

}   