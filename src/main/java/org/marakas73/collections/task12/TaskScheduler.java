package org.marakas73.collections.task12;

import java.util.*;

public class TaskScheduler {
    private final Map<String, Task> tasks;

    public TaskScheduler() {
        this.tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        if(task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        if(tasks.containsKey(task.getId())) {
            throw new IllegalArgumentException("Task with provided ID already exist: " + task.getId());
        }

        // Check if all task dependencies exist
        Set<String> taskDependencies = new HashSet<>(task.getDependencies());
        taskDependencies.removeAll(tasks.keySet());
        if(!taskDependencies.isEmpty()) {
            throw new IllegalArgumentException("Provided non-existed IDs in task dependencies");
        }

        tasks.put(task.getId(), task);

        if(task.getStatus() == TaskStatus.COMPLETED) {
            markTaskCompleted(task.getId());
        } else if (task.getStatus() == TaskStatus.FAILED) {
            markTaskFailed(task.getId());
        }
    }

    public void markTaskCompleted(String taskId) {
        var task = tasks.get(taskId);
        if(task == null) throw new IllegalArgumentException("No task found by provided ID: " + taskId);
        if(task.getStatus() == TaskStatus.PENDING) {
            throw new IllegalStateException("Task is not ready to run: " + task.getStatus());
        }

        if(!areAllDependenciesCompleted(task)) {
            throw new IllegalStateException(
                    "Cannot complete task because of not completed task in dependencies"
            );
        }

        // Complete target task
        task.setStatus(TaskStatus.COMPLETED);

        // Set dependants status to READY
        for(var t : tasks.values()) {
            Set<String> dependencies = t.getDependencies();
            if(dependencies.contains(taskId)) { // It's dependant for target task
                if(areAllDependenciesCompleted(t)) {
                    t.setStatus(TaskStatus.READY);
                }
            }
        }
    }

    public void markTaskFailed(String taskId) {
        var task = tasks.get(taskId);
        if(task == null) throw new IllegalArgumentException("No task found by provided ID: " + taskId);
        if(task.getStatus() == TaskStatus.COMPLETED) {
            throw new IllegalStateException("Task already in terminal state: " + task.getStatus());
        }

        // Set target task status to FAILED
        task.setStatus(TaskStatus.FAILED);

        // Recursively set dependants status to FAILED
        // Because dependants cannot be completed correctly when one of its dependencies ended with failure
        for(var t : tasks.values()) {
            Set<String> dependencies = t.getDependencies();
            if(dependencies.contains(taskId) && t.getStatus() != TaskStatus.COMPLETED) {
                // Mark dependant as FAILED because of dependency (target task)
                markTaskFailed(t.getId());
            }
        }
    }

    public List<Task> getReadyTasks() {
        List<Task> readyTasks = new ArrayList<>();
        for(var task : tasks.values()) {
            if(task.getStatus() == TaskStatus.READY) {
                readyTasks.add(task);
            }
        }
        return readyTasks;
    }

    public boolean hasCyclicDependency() {
        // Global visited list for all searches
        Set<String> visited = new HashSet<>();

        // Search cycled dependencies in each task
        for(var task : tasks.values()) {
            if(hasCycle(task, visited, new HashSet<>())) {
                return true;
            }
        }

        // No cycled dependencies
        return false;
    }

    public List<String> getExecutionOrder() {
        List<Task> sorted = new ArrayList<>(tasks.values());
        sorted.sort((a, b) -> Integer.compare(b.getPriority(), a.getPriority()));

        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for (Task task : sorted) {
            if ((task.getStatus() == TaskStatus.READY || task.getStatus() == TaskStatus.RUNNING)
                    && !visited.contains(task.getId())) {
                depthSearchForExecutionTasks(task, result, visited);
            }
        }

        return result;
    }

    public Map<TaskStatus, Integer> getTaskStatistics() {
        Map<TaskStatus, Integer> statisticsMap = new HashMap<>(TaskStatus.values().length);
        for(var task : tasks.values()) {
            statisticsMap.put(task.getStatus(), statisticsMap.getOrDefault(task.getStatus(), 0) + 1);
        }
        return statisticsMap;
    }

    private void depthSearchForExecutionTasks(Task task, List<String> result, Set<String> visited) {
        String taskId = task.getId();

        if (visited.contains(taskId)
                || task.getStatus() == TaskStatus.COMPLETED
                || task.getStatus() == TaskStatus.FAILED) {
            return;
        }

        List<Task> dependencies = new ArrayList<>();
        for (String dependencyId : task.getDependencies()) {
            Task dependencyTask = tasks.get(dependencyId);
            if (dependencyTask != null) {
                dependencies.add(dependencyTask);
            }
        }
        dependencies.sort((a, b) -> Integer.compare(b.getPriority(), a.getPriority()));
        for (Task dep : dependencies) {
            depthSearchForExecutionTasks(dep, result, visited);
        }

        result.add(taskId);
        visited.add(taskId);
    }

    private boolean hasCycle(Task task, Set<String> visited, Set<String> inRecursion) {
        if(task == null) return false;
        String taskId = task.getId();

        // Graph cycle searching algorithm

        if(inRecursion.contains(taskId)) return true;
        if(visited.contains(taskId)) return false;

        visited.add(taskId);
        inRecursion.add(taskId);

        for(var dependencyId : task.getDependencies()) {
            var dependencyTask = tasks.get(dependencyId);
            if(hasCycle(dependencyTask, visited, inRecursion)) {
                return true;
            }
        }

        inRecursion.remove(taskId);

        return false;
    }

    private boolean areAllDependenciesCompleted(Task task) {
        for(String dependencyId : task.getDependencies()) {
            var dependencyTask = tasks.get(dependencyId);
            if(dependencyTask == null) {
                throw new IllegalStateException("Dependency task expected but not found: " + dependencyId);
            }
            if(dependencyTask.getStatus() != TaskStatus.COMPLETED) {
                return false;
            }
        }
        return true;
    }
}
