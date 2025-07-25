package org.marakas73.streamapi;

import java.util.Collection;
import java.util.List;

/**
 * 11. Плоский список
 * Дан список списков чисел List<List<Integer>>. Создайте плоский список всех чисел
 */
public class Task11 {
    private static List<Integer> solve(List<List<Integer>> numbers2dList) {
        return numbers2dList.stream()
                .flatMap(Collection::stream)
                .toList();
    }

    public static void main(String[] args) {
        List<List<Integer>> numbers2dList = List.of(
                List.of(1, 2, 3, 4),
                List.of(5, 6, 7, 8),
                List.of(9, 10),
                List.of(-11, -12, -13, 14, 15),
                List.of(0)
        );

        System.out.println(solve(numbers2dList));
    }
}
