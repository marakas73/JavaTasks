package org.marakas73.regex;

import java.util.regex.Pattern;

/**
 * Задание 3
 * Написать метод, который извлекает все числа из строки и возвращает их сумму.
 *
 * public int extractAndSumNumbers(String text) {
 *     // Ваш код здесь
 * }
 *
 * Примеры:
 *
 * "У меня есть 5 яблок и 10 груш" → 15
 * "Нет чисел в тексте" → 0
 * "123abc456def789" → 1368
 */
public class Task3 {
    private final static String MASK = "\\d+";
    private final static Pattern PATTERN = Pattern.compile(MASK);

    public static int extractAndSumNumbers(String text) {
        return PATTERN.matcher(text).results()
                .map(matchResult -> matchResult.group(0))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static void main(String[] args) {
        String testText1 = "У меня есть 5 яблок и 10 груш";
        System.out.println(testText1 + " -> " + extractAndSumNumbers(testText1));

        String testText2 = "Нет чисел в тексте";
        System.out.println(testText2 + " -> " + extractAndSumNumbers(testText2));

        String testText3 = "123abc456def789";
        System.out.println(testText3 + " -> " + extractAndSumNumbers(testText3));
    }
}
