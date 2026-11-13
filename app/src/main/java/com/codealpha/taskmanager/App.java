package com.codealpha.taskmanager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            System.out.println("================================");
            System.out.println("       JAVA TASK MANAGER");
            System.out.println("================================");

            while (running) {
                System.out.println("\n1. Add Task");
                System.out.println("2. View Tasks");
                System.out.println("3. Complete Task");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        System.out.print("Enter task description: ");
                        try {
                            manager.addTask(scanner.nextLine());
                            System.out.println("Task added successfully!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case "2":
                        if (manager.getTasks().isEmpty()) {
                            System.out.println("No tasks available.");
                        } else {
                            System.out.println("\nYour Tasks:");

                            for (int i = 0; i < manager.getTasks().size(); i++) {
                                Task task = manager.getTasks().get(i);
                                String status = task.isCompleted()
                                    ? "Completed" : "Pending";

                                System.out.println(
                                    (i + 1) + ". " +
                                    task.getDescription() + " [" + status + "]"
                                );
                            }
                        }
                        break;

                    case "3":
                        System.out.print("Enter task number: ");

                        try {
                            int taskNumber = Integer.parseInt(
                                scanner.nextLine().trim()
                            );

                            if (manager.completeTask(taskNumber)) {
                                System.out.println("Task marked as completed!");
                            } else {
                                System.out.println("Invalid task number.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                        break;

                    case "4":
                        running = false;
                        System.out.println("Thank you for using Task Manager!");
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
    }
}
