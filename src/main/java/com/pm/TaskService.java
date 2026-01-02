package com.pm;

import java.util.List;

public class TaskService {
    TaskRepository repo = new TaskRepository();

    public String addTask(String description) {
        List<Task> tasks = repo.loadTasks();
        tasks.add(new Task(tasks.size() + 1, description));
        return repo.saveTask(tasks);
    }

    public void list(String filter) {
        System.out.println("sucess");
        List<Task> tasks = repo.loadTasks();
        for (Task task : tasks) {
            if (filter == null || task.getStatus().name().equals(filter)) {
                System.out.println(task.getId() + ". " + task.getDescription() + " [" + task.getStatus() + "]");
            }
        }
    }
        public void mark( Integer id,TaskStatus status){
        List<Task> tasks = repo.loadTasks();

        for (Task task : tasks){
            if(id == task.getId())
            {
                task.setStatus(status);
                repo.saveTask(tasks);
                System.out.println("Successfully updated");
            }
        }
            System.out.println("Task not found");;
    }
}

