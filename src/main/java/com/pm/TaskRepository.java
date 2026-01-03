package com.pm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private final Path path = Path.of("Tasks.json");

    public List<Task> loadTasks() {
        if (!Files.exists(path)) {

            return new ArrayList<>();
        }
        try {

            String context = Files.readString(path);

            return JsonUtil.fromJson(context);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from a file");
        }
    }

    public String saveTask(List<Task> task) {
        System.out.println(Path.of("").toAbsolutePath());

        if (!Files.exists(path)) return "File not found";
        try {
            Files.writeString(path, JsonUtil.toJson(task));
            return "Saved Successfully";
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to a file");
        }


    }


}
