package org.marakas73.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 21. Сумма квадратов
 * Вычислите сумму квадратов всех чисел в списке.
 */
public class Task21 {
    private static long solve(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .map(number -> number * number)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers = Arrays.asList(1, 2, 3, null, 4, 5, null, -1, 0);

        System.out.println(solve(sampleNumbers));
    }
}
