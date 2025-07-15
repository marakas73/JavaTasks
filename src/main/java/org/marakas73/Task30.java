package org.marakas73;

import java.util.List;
import java.util.Objects;

/**
 * 30. Цепочка операций
 * Дан список строк. Выполните следующие операции в одной цепочке:
 *
 * Отфильтруйте строки длиной больше 3 символов
 * Преобразуйте в верхний регистр
 * Отсортируйте по алфавиту
 * Соберите в строку, разделенную символом " | "
 */
public class Task30 {
    private static String solve(List<String> stringList) {
        return stringList.stream()
                .filter(str -> Objects.nonNull(str) && str.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .reduce("", (result, s) -> result + " | " + s).replaceFirst(" \\| ", "");
    }

    public static void main(String[] args) {
        List<String> sampleStringList = List.of(
                "ABCDE",
                "aaaa",
                "0111AaMh",
                "String1",
                ",r",
                "String1",
                "",
                "same",
                " ",
                "same",
                "ABC",
                "abc",
                "1234567"
        );

        System.out.println(solve(sampleStringList));
    }
}