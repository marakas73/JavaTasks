package org.marakas73.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 18. Подсчет символов
 * Подсчитайте общее количество символов во всех строках списка.
 */
public class Task18 {
    private static int solve(List<String> stringList) {
        return stringList.stream()
                .filter(Objects::nonNull)
                .map(String::length)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        List<String> sampleStringList = Arrays.asList(
                "1234",
                "123456789",
                "12",
                "1",
                null,
                "1234567",
                "123",
                null,
                null
        );

        System.out.println(solve(sampleStringList));
    }
}
