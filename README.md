# Java CLI Task Manager

A simple command-line Task Manager written in pure Java, built and compiled using Maven. The application allows users to manage tasks via terminal commands and stores data in a local JSON file.

Inspired by [roadmap.sh/projects/task-tracker](https://roadmap.sh/projects/task-tracker).

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Build](#build)
- [Usage](#usage)
  - [Add a task](#add-a-task)
  - [List all tasks](#list-all-tasks)
  - [List tasks by status](#list-tasks-by-status)
  - [Update a task](#update-a-task)
  - [Mark task as done](#mark-task-as-done)
  - [Mark task as in progress](#mark-task-as-in-progress)
  - [Delete a task](#delete-a-task)
- [Package as JAR](#package-as-jar)
- [Data Storage](#data-storage)
- [Architecture Overview](#architecture-overview)
- [Known Limitations](#known-limitations)
- [Contributing](#contributing)
- [License](#license)

## Features

- Add tasks
- List all tasks
- Filter tasks by status
- Update task description
- Mark tasks as done or in progress
- Delete tasks
- Persist tasks in a local JSON file (`Tasks.json`)

## Getting Started

### Prerequisites

- Java 17 or higher
- Apache Maven 3.8+

You can verify your installation by running:

```bash
java -version
mvn -version
```

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd Task_Tracker
   ```

### Build

Compile the project from the root directory:

```bash
mvn clean compile
```

This will generate the compiled `.class` files in the `target/classes` directory.

## Usage

The application is run using the `exec-maven-plugin`.

### Add a task

```bash
mvn exec:java -Dexec.args="add <task_description>"
```
**Example:**
```bash
mvn exec:java -Dexec.args="add 'Buy milk'"
```

### List all tasks

```bash
mvn exec:java -Dexec.args="list"
```

### List tasks by status

```bash
mvn exec:java -Dexec.args="list <status>"
```
**Available statuses:** `todo`, `inProgress`, `done`

**Example:**
```bash
mvn exec:java -Dexec.args="list todo"
```

### Update a task

```bash
mvn exec:java -Dexec.args="update <task_id> <new_description>"
```
**Example:**
```bash
mvn exec:java -Dexec.args="update 2 'Buy bread and milk'"
```

### Mark task as done

```bash
mvn exec:java -Dexec.args="mark-done <task_id>"
```
**Example:**
```bash
mvn exec:java -Dexec.args="mark-done 2"
```

### Mark task as in progress

```bash
mvn exec:java -Dexec.args="mark-in-progress <task_id>"
```
**Example:**
```bash
mvn exec:java -Dexec.args="mark-in-progress 2"
```

### Delete a task

```bash
mvn exec:java -Dexec.args="delete <task_id>"
```
**Example:**
```bash
mvn exec:java -Dexec.args="delete 2"
```

## Package as JAR

You can package the application as a runnable JAR file:

```bash
mvn clean package
```

The generated JAR file will be located at `target/task-manager-1.0.0.jar`.

You can run the JAR file directly:

```bash
java -jar target/task-manager-1.0.0.jar <command> <args>
```
**Example:**
```bash
java -jar target/task-manager-1.0.0.jar add 'Buy milk'
```

## Data Storage

Tasks are stored locally in a `Tasks.json` file in the project's root directory.

**Example:**
```json
[
  {
    "id": 1,
    "description": "Buy milk",
    "status": "todo",
    "createdAt": "2026-01-03",
    "updatedAt": "2026-01-03"
  }
]
```

## Architecture Overview

- **Main**: Entry point, parses CLI arguments, and delegates commands to `TaskService`.
- **TaskService**: Business logic layer, handles task operations.
- **TaskRepository**: Reads/writes tasks from/to the `Tasks.json` file using Java NIO.
- **JsonUtil**: Handles manual JSON parsing and generation.
- **Task**: The domain model for a task.

## Known Limitations

- Manual JSON parsing (not production-ready).
- No concurrency support.
- Task IDs are sequential and not reused after deletion.
- No validation for malformed JSON.

## Contributing

Contributions are welcome! Please feel free to submit a pull request.

## License

This project is licensed under the MIT License.
