package com.codealpha.taskmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException(
                "Task description cannot be empty."
            );
        }

        tasks.add(new Task(description.trim()));
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public boolean completeTask(int taskNumber) {
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            return false;
        }

        tasks.get(taskNumber - 1).markCompleted();
        return true;
    }
}
