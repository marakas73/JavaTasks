package org.marakas73.collections.task11;

public class TimedValue<T> {
    T value;
    private long timestampMillis;

    public TimedValue(T value) {
        this.value = value;
        this.timestampMillis = System.currentTimeMillis();
    }

    public void updateTimestamp() {
        this.timestampMillis = System.currentTimeMillis();
    }

    public boolean isExpired(long ttlMillis) {
        return (System.currentTimeMillis() - timestampMillis) > ttlMillis;
    }
}
