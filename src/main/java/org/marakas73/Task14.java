package org.marakas73;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 14. Партиционирование
 * Разделите список чисел на две группы: четные и нечетные
 */
public class Task14 {
    private static Map<Boolean, List<Integer>> solve(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, 0);

        Map<Boolean, List<Integer>> partedAnswer = solve(sampleNumbers);
        System.out.println("Even: " + partedAnswer.get(true));
        System.out.println("Odd: " + partedAnswer.get(false));
    }
}
