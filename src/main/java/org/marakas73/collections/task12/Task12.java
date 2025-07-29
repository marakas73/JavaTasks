package org.marakas73.collections.task12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * ### 12. Система управления задачами с приоритетами и зависимостями
 * Реализуйте систему управления задачами, где каждая задача имеет приоритет и
 * может зависеть от других задач. Система должна уметь планировать выполнение
 * задач с учетом зависимостей и приоритетов.
 *
 * **Дополнительные требования:**
 * Обнаружение циклических зависимостей
 * Эффективная обработка больших объемов задач
 * Возможность отмены задач и каскадная отмена зависимых задач
 * Реализация timeout для задач
 * Метрики производительности системы
 */
public class Task12 {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        Task A = new Task("A", 5, Collections.emptySet(), TaskStatus.PENDING);
        Task B = new Task("B", 3, Set.of("A"), TaskStatus.PENDING);
        Task C = new Task("C", 4, Set.of("A"), TaskStatus.PENDING);
        Task D = new Task("D", 2, Set.of("B", "C"), TaskStatus.PENDING);
        Task E = new Task("E", 1, Set.of("Z"), TaskStatus.PENDING); // will throw on add

        scheduler.addTask(A);
        scheduler.addTask(B);
        scheduler.addTask(C);
        scheduler.addTask(D);

        System.out.println("Ready tasks: " + extractIds(scheduler.getReadyTasks()));

        System.out.println("Execution order: " + scheduler.getExecutionOrder());

        A.setStatus(TaskStatus.READY);
        scheduler.markTaskCompleted("A");
        System.out.println("Ready after A completed: " + extractIds(scheduler.getReadyTasks()));

        System.out.println("Execution order: " + scheduler.getExecutionOrder());

        scheduler.markTaskFailed("B");
        System.out.println("After B failed, statistics: " + scheduler.getTaskStatistics());

        System.out.println("Cycle present: " + scheduler.hasCyclicDependency());

        // Attempt to add invalid task
        try {
            scheduler.addTask(E);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error adding E: " + ex.getMessage());
        }

        scheduler.markTaskCompleted("C");
        System.out.println("After C completed, statistics: " + scheduler.getTaskStatistics());

        System.out.println("Execution order: " + scheduler.getExecutionOrder());
    }

    private static List<String> extractIds(List<Task> tasks) {
        List<String> ids = new ArrayList<>();
        for (var task : tasks) {
            ids.add(task.getId());
        }
        return ids;
    }
}
