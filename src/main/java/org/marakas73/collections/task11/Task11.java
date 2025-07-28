package org.marakas73.collections.task11;

import java.util.Map;

/**
 * ### 11. Реализация многопоточного счетчика событий
 * Создайте потокобезопасный класс EventCounter, который подсчитывает количество
 * различных типов событий. Класс должен поддерживать concurrent доступ и предоставлять
 * методы для инкремента счетчика и получения статистики.
 *
 * **Дополнительные требования:**
 * Класс должен быть потокобезопасным
 * Метод getAllCounts() должен возвращать snapshot данных
 * Реализуйте метод для получения топ-N событий по частоте
 * Добавьте возможность установки TTL для событий
 */
public class Task11 {
    public static void main(String[] args) {
        EventCounter counter = new EventCounter();

        System.out.println("=== INCREMENT EVENTS ===");
        counter.incrementEvent("login");
        counter.incrementEvent("logout");
        counter.incrementEvent("login");
        counter.incrementEvent("download");
        counter.incrementEvent("download");
        counter.incrementEvent("download");

        System.out.println("Expected login = 2, actual = " + counter.getEventCount("login"));
        System.out.println("Expected logout = 1, actual = " + counter.getEventCount("logout"));
        System.out.println("Expected download = 3, actual = " + counter.getEventCount("download"));
        System.out.println("Expected upload (not incremented) = 0, actual = " + counter.getEventCount("upload"));

        System.out.println("\n=== SNAPSHOT ===");
        Map<String, Long> snapshot = counter.getAllCounts();
        snapshot.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\n=== MOST COUNTED EVENTS (Top 2) ===");
        Map<String, Long> top2 = counter.getMostCountedEvents(2);
        top2.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\n=== RESET ===");
        counter.reset();
        System.out.println("Expected login after reset = 0, actual = " + counter.getEventCount("login"));
        System.out.println("Expected size after reset = 0, actual = " + counter.getAllCounts().size());
    }
}
