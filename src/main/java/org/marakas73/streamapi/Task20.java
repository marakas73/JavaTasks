package org.marakas73.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 20. Начальные буквы
 * Получите список первых букв всех строк в списке.
 */
public class Task20 {
    private static List<Character> solve(List<String> stringList) {
        return stringList.stream()
                .filter(Objects::nonNull)
                .map(str -> str.chars()
                        .filter(Character::isLetter)
                        .mapToObj(sym -> (char) sym)
                        .findFirst()
                        .orElse(null))
                .toList();
    }

    public static void main(String[] args) {
        List<String> sampleStringList = Arrays.asList(
                "table",
                "   Longer string than other",
                null,
                null,
                "Hello world!",
                "123apple",
                "banana",
                "12314245",
                null,
                "Fix",
                "_refactor",
                "(*&)(*&^%^&$%^#&$%^#",
                "add",
                null
        );


        System.out.println(solve(sampleStringList));
    }
}
