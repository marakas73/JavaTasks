package org.marakas73.regex;

import java.util.regex.Pattern;

/**
 * Задание 4
 * Создать метод, который заменяет все последовательности пробелов (один или более) на один пробел и удаляет пробелы в начале и конце строки.
 *
 * public String normalizeSpaces(String text) {
 *     // Ваш код здесь
 * }
 *
 * Примеры:
 *
 * "  hello    world  " → "hello world"
 * "multiple   spaces   here" → "multiple spaces here"
 */
public class Task4 {
    private final static String MASK = "\\s+";
    private final static Pattern PATTERN = Pattern.compile(MASK);

    public static String normalizeSpaces(String text) {
        return PATTERN.matcher(text)
                .replaceAll(" ")
                .trim();
    }

    public static void main(String[] args) {
        String testText1 = "  hello    world  ";
        System.out.println(testText1 + " -> " + normalizeSpaces(testText1));

        String testText2 = "multiple   spaces   here";
        System.out.println(testText2 + " -> " + normalizeSpaces(testText2));

        String testText3 = "";
        System.out.println(testText3 + " -> " + normalizeSpaces(testText3));
    }
}
