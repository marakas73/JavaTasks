package org.marakas73.streamapi;

import java.util.List;

/**
 * 12. Уникальные элементы
 * Удалите дубликаты из списка строк и отсортируйте результат.
 */
public class Task12 {
    private static List<String> solve(List<String> stringList) {
        return stringList.stream()
                .distinct()
                .sorted()
                .toList();
    }

    public static void main(String[] args) {
        List<String> sampleStringList = List.of(
                "ABCDE",
                "ABCDE",
                "bh978OB34O8B",
                "same",
                "0111AaMh",
                "String1",
                "String1",
                "String1",
                "String2",
                "same",
                "same",
                "same",
                "ABC",
                "abc",
                "1234567",
                "1234567"
        );

        solve(sampleStringList).forEach(System.out::println);
    }
}
