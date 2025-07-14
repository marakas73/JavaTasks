package org.marakas73;

import java.util.stream.LongStream;

/**
 * 25. Факториал
 * Вычислите факториал числа, используя Stream.
 */
public class Task25 {
    private static long solve(long number) {
        return LongStream.range(2, number + 1)
                .reduce(1, (n1, n2) -> n1 * n2);
    }

    public static void main(String[] args) {
        int sampleNumber = 10;

        System.out.println(solve(sampleNumber));
    }
}
