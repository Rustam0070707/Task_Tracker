package com.pm;

import java.time.LocalDate;

public class Task {
   private Integer  id;
   private String description ;

   private  TaskStatus status;
   private LocalDate createdAt;
   private LocalDate updatedAt;

    public Task( Integer id, String description) {
    createdAt = LocalDate.now();
    updatedAt = LocalDate.now();
    this.status = TaskStatus.todo;
        this.description = description;
        this.id = id;
    }

    public Task() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
