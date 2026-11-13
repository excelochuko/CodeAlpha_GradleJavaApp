# Java Task Manager – Gradle Build Automation

A simple interactive Java command-line Task Manager built with **Java 21** and **Gradle**. This project demonstrates Java application development, dependency management, unit testing, and automated CI using GitHub Actions.

## Project Overview

The Task Manager allows users to manage tasks through an interactive terminal menu. It was developed as a practical DevOps project to demonstrate how Gradle can automate Java builds and tests.

## Features

- Add new tasks.
- View all tasks and their completion status.
- Mark tasks as completed.
- Validate empty task descriptions.
- Handle invalid menu choices and task numbers.
- Run automated unit tests using JUnit 5.

**Note:** Tasks are stored in memory and are cleared when the application exits.

## Technologies Used

- Java 21
- Gradle 8.14.4
- JUnit 5
- Git and GitHub
- GitHub Actions
- Linux / Ubuntu

## Project Structure

```text
CodeAlpha_GradleJavaApp/
├── .github/
│   └── workflows/
│       └── gradle-ci.yml
├── app/
│   ├── build.gradle
│   └── src/
│       ├── main/java/com/codealpha/taskmanager/
│       │   ├── App.java
│       │   ├── Task.java
│       │   └── TaskManager.java
│       └── test/java/com/codealpha/taskmanager/
│           └── TaskManagerTest.java
├── gradle/
│   ├── libs.versions.toml
│   └── wrapper/
├── gradlew
├── gradlew.bat
├── settings.gradle
└── README.md
```

## Prerequisites

- Java Development Kit (JDK) 21
- Git
- Internet connection for the initial Gradle dependency and wrapper downloads

The project includes the Gradle Wrapper, so a separate Gradle installation is not required.

## Getting Started

Clone the repository:

```bash
git clone https://github.com/excelochuko/CodeAlpha_GradleJavaApp.git
cd CodeAlpha_GradleJavaApp
```

Check your Java version:

```bash
java -version
```

## Build the Application

On Linux or macOS:

```bash
chmod +x gradlew
./gradlew clean build
```

On Windows:

```powershell
.\gradlew.bat clean build
```

## Run the Application

On Linux or macOS:

```bash
./gradlew :app:run
```

On Windows:

```powershell
.\gradlew.bat :app:run
```

## Run Unit Tests

```bash
./gradlew clean test
```

The project includes five JUnit tests covering:

- Successful task creation.
- Rejection of empty task descriptions.
- Successful task completion.
- Invalid task-number handling.
- Default pending status of new tasks.

Test reports are generated at:

```text
app/build/reports/tests/test/
```

## CI/CD with GitHub Actions

The project uses GitHub Actions to automate the Gradle build and testing process.

Workflow file:

```text
.github/workflows/gradle-ci.yml
```

The workflow:

1. Checks out the repository.
2. Sets up Java 21.
3. Configures Gradle.
4. Runs `./gradlew clean test build`.
5. Uploads the generated application JAR.
6. Uploads the test reports.

The workflow runs on pushes and pull requests targeting `main` or `master`, and can also be started manually.

### Successful CI Run

The first GitHub Actions workflow completed successfully.

[View Successful GitHub Actions Run](https://github.com/excelochuko/CodeAlpha_GradleJavaApp/actions/runs/43426634844)

## Build Output

The generated application JAR is located at:

```text
app/build/libs/app.jar
```

## Learning Outcomes

Through this project, I gained practical experience in:

- Creating and structuring a Java application with Gradle.
- Managing project dependencies.
- Writing and executing JUnit unit tests.
- Automating builds and tests with GitHub Actions.
- Managing source code with Git and GitHub.
- Publishing build artifacts through a CI workflow.

## Repository

[GitHub – CodeAlpha_GradleJavaApp](https://github.com/excelochuko/CodeAlpha_GradleJavaApp)

---

**Project:** CodeAlpha – Java Application Using Gradle  
**Author:** Excel Faleye
