package org.marakas73.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 28. Фильтрация и преобразование
 * Из списка чисел оставьте только четные, возведите их в квадрат и найдите сумму.
 */
public class Task28 {
    private static long solve(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> Objects.nonNull(number) && number % 2 == 0)
                .reduce(0, (sum, num) -> sum + num * num);
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers = Arrays.asList(1, 2, 5, 3, 3, null, 4, 5, 5, null, -1);

        System.out.println(solve(sampleNumbers));
    }
}
