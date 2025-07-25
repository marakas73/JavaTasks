package org.marakas73.streamapi;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 16. Объединение строк
 * Объедините все строки из списка в одну строку, разделенную запятыми.
 */
public class Task16 {
    private static String solve(List<String> stringList) {
        return stringList.stream()
                .collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        List<String> sampleStringList = List.of("table", "longer string than other", "Hello world!", "apple", "banana");

        System.out.println(solve(sampleStringList));
    }
}
