package com.examly.springapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class TaskController {
    
    private TaskService askService;

    @Autowired
    public TaskController(TaskService taskService)  {
        this.taskService = taskService;
    }

    @PostMapping("/saveTask")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto)  {
        return new ResponseEntity<>(taskService.createTask(taskDto),  HttpStatus.OK);
    }

    @GetMapping("/alltasks")
    public List<TaskDto> getAllTasks()  {
        return taskService.getAllTasks();
    }

    @GetMapping("/getTask")
    public ResponseEntity<TaskDto> getTaskById(@RequestParam long id)  {
        return new ResponseEntity<>(taskService.getTaskById(id),  HttpStatus.OK);
    }

    @GetMapping("/deleteTask")
    public ResponseEntity<TaskDto> deleteTask(@RequestParam long id)  {
        return new ResponseEntity<>(taskService.deleteTask(id),  HttpStatus.OK);
    }

    @GetMapping("/changeStatus")
    public ResponseEntity<TaskDto> changeStatus(@RequestParam long id,  @RequestBody TaskDto taskDto     return new ResponseEntity<>(taskService.changeStatus(id, taskDto), HttpStatus.OK);
    }  
}
