package org.marakas73.collections.task11;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * java
 * public class EventCounter {
 *     // Используйте подходящие concurrent коллекции
 *     public void incrementEvent(String eventType) {
 *         // Ваш код здесь
 *     }
 *     public long getEventCount(String eventType) {
 *         // Ваш код здесь
 *     }
 *     public Map<String, Long> getAllCounts() {
 *         // Ваш код здесь
 *     }
 *     public void reset() {
 *         // Ваш код здесь
 *     }
 * }
 *
 * **Дополнительные требования:**
 * +Класс должен быть потокобезопасным
 * +Метод getAllCounts() должен возвращать snapshot данных
 * +Реализуйте метод для получения топ-N событий по частоте
 * Добавьте возможность установки TTL для событий
 */
public class EventCounter {
    private final Map<String, Long> eventsCount;

    public EventCounter() {
        this.eventsCount = new ConcurrentHashMap<>();
    }

    public void incrementEvent(String eventType) {
        eventsCount.compute(eventType, (key, value) -> value == null ? 1L : value + 1L);
    }

    public long getEventCount(String eventType) {
        // Return event count or 0 (event not in the map means zero uses of it)
        return eventsCount.getOrDefault(eventType, 0L);
    }

    public Map<String, Long> getAllCounts() {
        // Data snapshot (shallow copy)
        return Map.copyOf(eventsCount);
    }

    public Map<String, Long> getMostCountedEvents(int n) {
        // Working with snapshot (thread-safe)
        Map<String, Long> countSnapshot = getAllCounts();

        // Sort entries in ascending order
        List<Map.Entry<String, Long>> entries = new ArrayList<>(countSnapshot.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        // Generating answer map
        Map<String, Long> answerMap = new LinkedHashMap<>(n);
        // Use limited by 'n' entries in descending order
        // Also limit 'n' by entries size
        for(var entry : entries.reversed().subList(0, Math.min(n, entries.size()))) {
            answerMap.put(entry.getKey(), entry.getValue());
        }

        return answerMap;
    }

    public void reset() {
        eventsCount.clear();
    }
}