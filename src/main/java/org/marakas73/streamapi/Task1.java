package org.marakas73.streamapi;

import java.util.Arrays;
import java.util.List;

/**
 * 1. Фильтрация четных чисел
 * Дан список чисел List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10). Отфильтруйте только четные числа и выведите их.
 */
public class Task1 {
    private static List<Integer> solve(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        solve(sampleNumbers)
                .forEach(System.out::println);
    }
}
