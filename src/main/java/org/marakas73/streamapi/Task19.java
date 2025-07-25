package org.marakas73.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 19. Фильтрация по длине
 * Отфильтруйте строки, длина которых больше 5 символов.
 */
public class Task19 {
    private static List<String> solve(List<String> stringList) {
        return stringList.stream()
                .filter(str -> Objects.nonNull(str) && str.length() > 5)
                .toList();
    }

    public static void main(String[] args) {
        List<String> sampleStringList = Arrays.asList(
                "1234",
                "123456789",
                "123456",
                "1",
                null,
                "1234567",
                "12345",
                null,
                null
        );

        solve(sampleStringList).forEach(System.out::println);
    }
}