📝 Java CLI Task Manager (Maven)

A simple command-line Task Manager written in pure Java, built and compiled using Maven.
The application allows users to manage tasks via terminal commands and stores data in a local JSON file.

This project demonstrates:

Java OOP fundamentals

Maven project structure & build lifecycle

Command-line argument handling

File I/O using Java NIO

Manual JSON serialization/deserialization

Layered architecture (CLI → Service → Repository)

📂 Project Structure (Maven)
task-manager/
├── pom.xml
└── src
    └── main
        └── java
            └── com
                └── pm
                    ├── Main.java
                    ├── Task.java
                    ├── TaskStatus.java
                    ├── TaskService.java
                    ├── TaskRepository.java
                    └── JsonUtil.java


Package name: com.pm

Entry point: com.pm.Main

⚙️ Features

Add tasks

List all tasks

Filter tasks by status

Update task description

Mark tasks as done or in progress

Delete tasks

Persist tasks in a local JSON file (Tasks.json)

🧰 Requirements

Java 17 or higher

Apache Maven 3.8+

Verify:

```bash
java -version
```
```bash
mvn -version
```

🔨 Build & Compile (Maven)

From the project root:

```bash
mvn clean compile
```


This compiles the project and generates .class files in:

target/classes

▶️ Run the Application (Maven)

The project uses exec-maven-plugin to run the CLI.

➕ Add a task
```bash
mvn exec:java -Dexec.args="add Buy milk"
```

📃 List all tasks
```bash
mvn exec:java -Dexec.args="list"
```

📃 List tasks by status
```bash
mvn exec:java -Dexec.args="list todo"
```
```bash
mvn exec:java -Dexec.args="list inProgress"
```
```bash
mvn exec:java -Dexec.args="list done"
```

✏️ Update a task
```bash
mvn exec:java -Dexec.args="update 2 Buy bread and milk"
```

✅ Mark task as done
```bash
mvn exec:java -Dexec.args="mark-done 2"
```

⏳ Mark task as in progress
```bash
mvn exec:java -Dexec.args="mark-in-progress 2"
```

❌ Delete a task
```bash
mvn exec:java -Dexec.args="delete 2"
```

📦 Package as JAR
```bash
mvn clean package
```


Generated file:

target/task-manager-1.0.0.jar


Run the JAR:

```bash
java -jar target/task-manager-1.0.0.jar add Buy milk
```

🗂 Data Storage

Tasks are stored locally in:

Tasks.json

Example:
[
  {
    "id": 1,
    "description": "Buy milk",
    "status": "todo",
    "createdAt": "2026-01-03",
    "updatedAt": "2026-01-03"
  }
]

🧠 Architecture Overview
Main

Entry point

Parses CLI arguments

Delegates commands to TaskService

TaskService

Business logic layer

Handles task operations

TaskRepository

Reads/writes tasks from/to file

Uses Java NIO (Files, Path)

JsonUtil

Manual JSON parsing & generation

No external libraries used

Task

Domain model

Stores task data and timestamps

⚠️ Known Limitations

Manual JSON parsing (not production-ready)

No concurrency support

Task IDs are sequential

No validation for malformed JSON

🎯 Purpose

This project is intended for:

Java fundamentals practice

Learning Maven basics

CLI application development

Interview preparation (Java + Maven + OOP + File I/O)