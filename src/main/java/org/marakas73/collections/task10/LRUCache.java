package org.marakas73.collections.task10;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity);
    }

    public V get(K key) {
        // Update LRU and return cached value, or null if no value by this key
        var cachedValue = cache.get(key);
        if(cachedValue != null) {
            // Move cached value in the end (as most recently used)
            cache.remove(key);
            cache.put(key, cachedValue);
        }
        return cachedValue;
    }

    public void put(K key, V value) {
        // Check if capacity exceeded - remove LRU cache
        if(cache.size() >= capacity) {
            // Remove first cached value (last recently used)
            Iterator<Map.Entry<K, V>> cacheIterator = cache.entrySet().iterator();
            if(cacheIterator.hasNext()) {
                cache.remove(cacheIterator.next().getKey());
            }
        }
        // Add cached value (already in the end as most recently used)
        cache.put(key, value);
    }

    @Override
    public String toString() {
        return "LRUCache=" + cache.entrySet();
    }
}
