package org.marakas73.regex;

import java.util.regex.Pattern;

/**
 * Задание 7
 * Написать метод, который форматирует номер банковской карты, разбивая его на группы по 4 цифры, разделенные пробелами. Входная строка может содержать пробелы и дефисы.
 *
 * public String formatCardNumber(String cardNumber) {
 *     // Ваш код здесь
 *     // Возвращать null если номер невалидный (не 16 цифр)
 * }
 *
 * Примеры:
 *
 * "1234567890123456" → "1234 5678 9012 3456"
 * "1234-5678-9012-3456" → "1234 5678 9012 3456"
 * "1234 56" → null
 */
public class Task7 {
    private final static String TOTAL_MASK = "^\\d{4}[ -]*\\d{4}[ -]*\\d{4}[ -]*\\d{4}$";
    private final static Pattern TOTAL_PATTERN = Pattern.compile(TOTAL_MASK);
    private final static String DIGIT_MASK = "\\d{4}";
    private final static Pattern DIGIT_PATTERN = Pattern.compile(DIGIT_MASK);

    public static String formatCardNumber(String cardNumber) {
        if(!TOTAL_PATTERN.matcher(cardNumber).matches()) {
            return null;
        }

        return DIGIT_PATTERN.matcher(cardNumber).results()
                .map(matchResult -> matchResult.group(0))
                .reduce("", (acc, s) -> acc + " " + s);
    }

    public static void main(String[] args) {
        String testCardNumber1 = "1234567890123456";
        System.out.println(testCardNumber1 + " -> " + formatCardNumber(testCardNumber1));

        String testCardNumber2 = "1234-5678-9012-3456";
        System.out.println(testCardNumber2 + " -> " + formatCardNumber(testCardNumber2));

        String testCardNumber3 = "1234 56";
        System.out.println(testCardNumber3 + " -> " + formatCardNumber(testCardNumber3));

        String testCardNumber4 = "";
        System.out.println(testCardNumber4 + " -> " + formatCardNumber(testCardNumber4));
    }
}
