package com.codealpha.taskmanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void shouldAddTaskSuccessfully() {
        TaskManager manager = new TaskManager();

        manager.addTask("Learn Gradle");

        assertEquals(1, manager.getTasks().size());
        assertEquals("Learn Gradle",
            manager.getTasks().get(0).getDescription());
    }

    @Test
    void shouldRejectEmptyTask() {
        TaskManager manager = new TaskManager();

        assertThrows(IllegalArgumentException.class,
            () -> manager.addTask(" "));
    }

    @Test
    void shouldMarkTaskAsCompleted() {
        TaskManager manager = new TaskManager();
        manager.addTask("Build Java application");

        boolean result = manager.completeTask(1);

        assertTrue(result);
        assertTrue(manager.getTasks().get(0).isCompleted());
    }

    @Test
    void shouldRejectInvalidTaskNumber() {
        TaskManager manager = new TaskManager();
        manager.addTask("Write unit tests");

        assertFalse(manager.completeTask(5));
        assertFalse(manager.completeTask(0));
    }

    @Test
    void newTaskShouldBePending() {
        TaskManager manager = new TaskManager();
        manager.addTask("Configure CI/CD");

        assertFalse(manager.getTasks().get(0).isCompleted());
    }
}
