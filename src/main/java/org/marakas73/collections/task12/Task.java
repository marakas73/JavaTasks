package org.marakas73.collections.task12;

import java.util.Set;

class Task {
    private final String id;
    private final int priority;
    private final Set<String> dependencies;
    private TaskStatus status;

    Task(String id, int priority, Set<String> dependencies, TaskStatus status) {
        this.id = id;
        this.priority = priority;

        if(dependencies.contains(id)) {
            throw new IllegalArgumentException("Task cannot depend on itself");
        }
        this.dependencies = dependencies;

        this.status = status;
    }

    public String getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public Set<String> getDependencies() {
        return dependencies;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
