package org.marakas73;

import java.util.Arrays;
import java.util.List;

/**
 * 2. Преобразование строк в верхний регистр
 * Дан список строк List<String> words = Arrays.asList("apple", "banana", "cherry"). Преобразуйте все строки в верхний регистр.
 */
public class Task2 {
    private static List<String> solve(List<String> words) {
        return words.stream()
                .map(String::toUpperCase)
                .toList();
    }

    public static void main(String[] args) {
        List<String> sampleWords = Arrays.asList("apple", "banana", "cherry");

        solve(sampleWords)
                .forEach(System.out::println);
    }
}
