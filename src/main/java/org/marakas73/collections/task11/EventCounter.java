package org.marakas73.collections.task11;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
    private final Map<String, TimedValue<Long>> eventsCount;
    private final long ttlMillis;
    private final ScheduledExecutorService cleaner;

    public EventCounter(long ttlMillis) {
        this.ttlMillis = ttlMillis;
        this.eventsCount = new ConcurrentHashMap<>();
        this.cleaner = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

        startBackgroundCleanup();
    }

    private void startBackgroundCleanup() {
        cleaner.scheduleAtFixedRate(() -> {
            for (Map.Entry<String, TimedValue<Long>> entry : eventsCount.entrySet()) {
                if (entry.getValue().isExpired(ttlMillis)) {
                    eventsCount.remove(entry.getKey(), entry.getValue());
                }
            }
        }, ttlMillis, ttlMillis, TimeUnit.MILLISECONDS);
    }

    public void incrementEvent(String eventType) {
        eventsCount.compute(eventType, (_, timedValue) -> {
            if(timedValue == null || timedValue.isExpired(ttlMillis)) {
                return new TimedValue<>(1L); // Return new value if not exist or expired by TTL
            }

            // Or update and return current value
            timedValue.value++;
            timedValue.updateTimestamp();
            return timedValue;
        });
    }

    public long getEventCount(String eventType) {
        // Return event count or 0 (event not in the map means zero uses of it)
        var timedValue = eventsCount.get(eventType);
        return timedValue == null ? 0L : timedValue.value;
    }

    public Map<String, Long> getAllCounts() {
        // Create snapshot of counts with Long unboxing
        Map<String, Long> snapshot = new HashMap<>(eventsCount.size());
        for(Map.Entry<String, TimedValue<Long>> entry : eventsCount.entrySet()) {
            snapshot.put(entry.getKey(), entry.getValue().value);
        }

        return snapshot;
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

    public void shutdown() {
        cleaner.shutdownNow();
    }
}