package org.marakas73.collections;

import java.util.Collections;
import java.util.List;

/**
 * ### 9. Поиск второго по величине элемента
 * Напишите метод, который находит второй по величине элемент в списке целых чисел без сортировки.
 *
 * java
 * public static Integer findSecondLargest(List<Integer> numbers) {
 *     // Ваш код здесь
 * }
 */
public class Task9 {
    public static Integer findSecondLargest(List<Integer> numbers) {
        if(numbers == null || numbers.isEmpty()) return null;
        if(numbers.size() <= 2) return Collections.min(numbers);

        Integer firstMax = null;
        Integer secondMax = null;

        for(var number : numbers) {
            if(firstMax == null || number > firstMax) {
                secondMax = firstMax;
                firstMax = number;
            } else if(number < firstMax && (secondMax == null || number > secondMax)) {
                secondMax = number;
            }
        }

        return secondMax == null ? firstMax : secondMax;
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers = List.of(5, 1, 4, 5, 2, 1, 0);

        System.out.println(findSecondLargest(sampleNumbers));
    }
}
