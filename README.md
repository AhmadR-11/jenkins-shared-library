# Jenkins Shared Library

This repository contains reusable Jenkins Pipeline code to standardize our CI/CD processes.

## 📁 `src/org/devops/` (Classes)

These are Object-Oriented Groovy classes that perform complex logic.

### 1. `NotificationService`
Handles all external notifications (Slack, Email).
**Example:**
```groovy
def notifier = new org.devops.NotificationService(this)
notifier.sendSlack("Hello Team!")
```

### 2. `DockerHelper`
Handles building and pushing Docker containers.
**Example:**
```groovy
def docker = new org.devops.DockerHelper(this)
docker.buildImage("my-app", "v1.0")
```

---

## 📁 `vars/` (Global Variables / Pipeline Steps)

These scripts act as global commands that can be called directly inside any Jenkinsfile.

### 1. `notifySlack(Map config)`
Sends a Slack notification. Validates that `message` is provided.
**Example:**
```groovy
notifySlack(message: "Pipeline finished!", channel: "#devops")
```

### 2. `buildAndPushImage(Map config)`
Builds and pushes a Docker image. Validates `name` and `tag`.
**Example:**
```groovy
buildAndPushImage(name: "my-app", tag: "latest")
```

### 3. `runSonarScan(Map config)`
Executes a SonarQube analysis. Validates `projectKey` and `sonarToken`.
**Example:**
```groovy
runSonarScan(projectKey: "my-app-key", sonarToken: "secret123")
```
