package org.marakas73.collections.task10;

/**
 * ### 10. Реализация простого кеша LRU
 * Создайте простую реализацию LRU (Least Recently Used) кеша фиксированного размера, используя LinkedHashMap.
 *
 * java
 * public class LRUCache<K, V> {
 *     private final int capacity;
 *     private final Map<K, V> cache;
 *
 *     public LRUCache(int capacity) {
 *         this.capacity = capacity;
 *         // Инициализация кеша
 *     }
 *
 *     public V get(K key) {
 *         // Ваш код здесь
 *     }
 *
 *     public void put(K key, V value) {
 *         // Ваш код здесь
 *     }
 * }
 */
public class Task10 {
    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);
        System.out.println("initial:" + lruCache);


        // Overfilling cache
        lruCache.put("one", 1);
        System.out.println("after put:" + lruCache);

        lruCache.put("two", 2);
        System.out.println("after put:" + lruCache);

        lruCache.put("three", 3);
        System.out.println("after put:" + lruCache);

        lruCache.put("four", 4);
        System.out.println("after put:" + lruCache);

        lruCache.put("five", 5);
        System.out.println("after put:" + lruCache);


        // Get and put
        System.out.println("get by key 'three':" + lruCache.get("three"));
        System.out.println("after get:" + lruCache);

        lruCache.put("ten", 10);
        System.out.println("after put:" + lruCache);
        System.out.println();
    }
}
