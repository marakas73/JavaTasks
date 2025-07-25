package org.marakas73.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 23. Максимальное и минимальное
 * Найдите максимальное и минимальное значение в списке чисел.
 */
public class Task23 {
    private static SolutionResult solve(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.teeing(
                        Collectors.minBy(Integer::compare),
                        Collectors.maxBy(Integer::compare),
                        (minOpt, maxOpt) -> new SolutionResult(minOpt.orElse(null), maxOpt.orElse(null))
        ));
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers = Arrays.asList(1, 2, 5, 3, 3, null, 4, 5, 5, null, -1);

        SolutionResult result = solve(sampleNumbers);
        System.out.println("Min: " + result.min);
        System.out.println("Max: " +result.max);
    }

    private record SolutionResult(Integer min, Integer max) {}
}
