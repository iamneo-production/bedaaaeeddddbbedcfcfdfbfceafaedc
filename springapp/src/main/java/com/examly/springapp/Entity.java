package com.examly.springapp;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tasks", uniqueConstraints = {@UniqueConstraint(columnNames = {"taskId"})})
public class Task {

    @Id
    private long taskId; 

	@Column(name="taskHolderName",nullable = false)
    private String taskHolderName;
    
	@Column(name="taskDate",nullable = false)
    private String taskDate;
	@Column(name="taskName",nullable = false)
    private String taskName;
	@Column(name="taskStatus",nullable = false)
    private String taskStatus;

    public Task(){

    }

    public Task(long taskId, String taskHolderName, String taskDate, String taskName, String taskStatus) {
        this.taskId = taskId;
        this.taskHolderName = taskHolderName;
        this.taskDate = taskDate;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
    }

    

    @Override
    public String toString() {
        return "Task [taskDate=" + taskDate + ", taskHolderName=" + taskHolderName + ", taskId=" + taskId
                + ", taskName=" + taskName + ", taskStatus=" + taskStatus + "]";
    }



    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskHolderName() {
        return taskHolderName;
    }

    public void setTaskHolderName(String taskHolderName) {
        this.taskHolderName = taskHolderName;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

}
