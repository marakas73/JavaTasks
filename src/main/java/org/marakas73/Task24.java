package org.marakas73;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;

/**
 * 24. Статистика
 * Получите статистику (count, sum, min, max, average) для списка чисел, используя summaryStatistics().
 */
public class Task24 {
    private static IntSummaryStatistics solve(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .summaryStatistics();
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers = Arrays.asList(1, 2, 5, 3, 3, null, 4, 5, 5, null, -1);

        IntSummaryStatistics statistics = solve(sampleNumbers);
        System.out.println("Count: " + statistics.getCount());
        System.out.println("Sum: " + statistics.getSum());
        System.out.println("Min: " + statistics.getMin());
        System.out.println("Max: " + statistics.getMax());
        System.out.println("Average: " + statistics.getAverage());
    }
}
