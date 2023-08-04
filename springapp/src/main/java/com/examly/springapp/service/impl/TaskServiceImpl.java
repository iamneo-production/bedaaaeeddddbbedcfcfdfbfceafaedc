package com.examly.springapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.examly.springapp.entity.Task;
import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.payload.TaskDto;
import com.examly.springapp.repository.TaskRepository;
import com.examly.springapp.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository =  taskRepository;
    }

    @Override
    public TaskDto createTask(TaskDto taskDto){
        
        Task post = mapToEntity(taskDto);
		
		Task newPost = taskRepository.save(post);
		
		// convert Entity to DTO
		
		TaskDto taskResponse = mapToDto(newPost);
        return taskResponse;
    }


    @Override
    public List<TaskDto> getAllTasks(){
        List<Task> tasks = taskRepository.findAll();
        List<TaskDto> listofTask = tasks.stream().map(task -> mapToDto(task)).collect(Collectors.toList());
        return listofTask;
    }

    @Override
    public TaskDto getTaskById(long taskId){
       Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task","taskId", taskId));
       return mapToDto(task);
    }

    @Override
    public TaskDto deleteTask(long taskId){
      Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task","taskId", taskId));
       taskRepository.delete(task);
        return mapToDto(task);
    }

    @Override
    public TaskDto changeStatus(long id,TaskDto taskDto)
    {
      Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task","taskId", id));
        task.setTaskId(taskDto.getTaskId());
        task.setTaskHolderName(taskDto.getTaskHolderName());
        task.setTaskDate(taskDto.getTaskDate());
        task.setTaskName(taskDto.getTaskName());
        task.setTaskStatus(taskDto.getTaskStatus());
        taskRepository.save(task);
        TaskDto taskResponse = mapToDto(task);
        return taskResponse;
    }

    public TaskDto mapToDto(Task task) {
		TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(task.getTaskId());
        taskDto.setTaskHolderName(task.getTaskHolderName());
        taskDto.setTaskDate(task.getTaskDate());
        taskDto.setTaskName(task.getTaskName());
        taskDto.setTaskStatus(task.getTaskStatus());
		
		return taskDto;
	}
	
	public Task mapToEntity(TaskDto taskDto) {
		Task task = new Task();
        task.setTaskId(taskDto.getTaskId());
        task.setTaskHolderName(taskDto.getTaskHolderName());
        task.setTaskDate(taskDto.getTaskDate());
        task.setTaskName(taskDto.getTaskName());
        task.setTaskStatus(taskDto.getTaskStatus());
		return task;
	}
    

}
