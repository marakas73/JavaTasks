package org.marakas73.collections.task8;

/**
 * ### 8. Реализация стека на основе ArrayList
 * Создайте класс MyStack<T>, который реализует базовые операции стека (push, pop, peek, isEmpty) используя ArrayList.
 *
 * java
 * public class MyStack<T> {
 *     private List<T> elements;
 *
 *     public MyStack() {
 *         elements = new ArrayList<>();
 *     }
 *
 *     // Реализуйте методы push, pop, peek, isEmpty
 * }
 */
public class Task8 {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        System.out.println("initial:" + myStack);

        // Push
        System.out.println("pushed=" + myStack.push(1));
        System.out.println("after push:" + myStack);

        System.out.println("pushed=" + myStack.push(2));
        System.out.println("after push:" + myStack);

        System.out.println("pushed=" + myStack.push(3));
        System.out.println("after push:" + myStack);

        // IsEmpty
        System.out.println("isEmpty()=" + myStack.isEmpty());

        // Pop & Peek
        System.out.println("popped=" + myStack.pop());
        System.out.println("after pop:" + myStack);

        System.out.println("peeked=" + myStack.peek());
        System.out.println("after peek:" + myStack);

        System.out.println("popped=" + myStack.pop());
        System.out.println("after pop:" + myStack);

        System.out.println("popped=" + myStack.pop());
        System.out.println("after pop:" + myStack);

        // IsEmpty
        System.out.println("isEmpty()=" + myStack.isEmpty());

        // Testing pop on empty stack
        try {
            System.out.println("peeked=" + myStack.peek());
            System.out.println("after peek:" + myStack);
        } catch (Exception e) {
            System.out.println("while peek caught this exception: " + e.getClass());
        }

        // IsEmpty
        System.out.println("isEmpty()=" + myStack.isEmpty());

        // Testing pop on empty stack
        try {
            System.out.println("popped=" + myStack.pop());
            System.out.println("after pop:" + myStack);
        } catch (Exception e) {
            System.out.println("while pop caught this exception: " + e.getClass());
        }
    }
}
