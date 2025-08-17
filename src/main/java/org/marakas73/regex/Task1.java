package org.marakas73.regex;

import java.util.regex.Pattern;

/**
 * Задание 1
 * Написать метод, который проверяет, является ли строка валидным номером телефона в формате +7(XXX)XXX-XX-XX.
 *
 * public boolean isValidPhoneNumber(String phone) {
 *     // Ваш код здесь
 * }
 *
 * Примеры:
 *
 * +7(123)456-78-90 → true
 * +7123456-78-90 → false
 * +8(123)456-78-90 → false
 */
public class Task1 {
    private final static String MASK = "^\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    private final static Pattern PATTERN = Pattern.compile(MASK);

    public static boolean isValidPhoneNumber(String phone) {
        return PATTERN.matcher(phone).matches();
    }

    public static void main(String[] args) {
        String testPhoneNumber1 = "+7(123)456-78-90";
        System.out.println(testPhoneNumber1 + " -> " + isValidPhoneNumber(testPhoneNumber1));

        String testPhoneNumber2 = "+7123456-78-90";
        System.out.println(testPhoneNumber2 + " -> " + isValidPhoneNumber(testPhoneNumber2));

        String testPhoneNumber3 = "+8(123)456-78-90";
        System.out.println(testPhoneNumber3 + " -> " + isValidPhoneNumber(testPhoneNumber3));

        String testPhoneNumber4 = "";
        System.out.println(testPhoneNumber4 + " -> " + isValidPhoneNumber(testPhoneNumber4));
    }
}
