package org.marakas73;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 22. Произведение чисел
 * Найдите произведение всех чисел в списке
 */
public class Task22 {
    private static long solve(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .reduce(1, (n1, n2) -> n1 * n2);
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers = Arrays.asList(1, 2, 3, null, 4, 5, null, -1);

        System.out.println(solve(sampleNumbers));
    }
}
