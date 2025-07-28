package org.marakas73.collections.task8;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private List<T> elements;

    public MyStack() {
        elements = new ArrayList<>();
    }

    public T push(T element) {
        elements.add(element);
        return element;
    }

    public synchronized T pop() {
        if(elements.isEmpty()) throw new MyStackEmptyException();
        return elements.removeLast();
    }

    public synchronized T peek() {
        if(elements.isEmpty()) throw new MyStackEmptyException();
        return elements.getLast();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public String toString() {
        return "MyStack=" + elements;
    }
}
