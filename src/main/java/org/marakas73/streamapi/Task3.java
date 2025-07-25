package org.marakas73.streamapi;

import java.util.List;

/**
 * 3. Подсчет элементов больше 5
 * Дан список чисел. Подсчитайте количество элементов, которые больше 5.
 */
public class Task3 {
    private static long solve(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 5)
                .count();
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(solve(sampleNumbers));
    }
}
