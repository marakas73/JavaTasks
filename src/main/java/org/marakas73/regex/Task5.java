package org.marakas73.regex;

import java.util.regex.Pattern;

/**
 * Задание 5
 * Написать метод, который проверяет силу пароля. Пароль считается сильным, если:
 *
 * Длина от 8 до 20 символов
 * Содержит хотя бы одну заглавную букву
 * Содержит хотя бы одну строчную букву
 * Содержит хотя бы одну цифру
 * Содержит хотя бы один специальный символ (!@#$%^&*)
 *
 * public boolean isStrongPassword(String password) {
 *     // Ваш код здесь
 * }
 *
 * Примеры:
 *
 * "MyPass123!" → true
 * "weakpass" → false
 * "NODIGITS!" → false
 */
public class Task5 {
    private final static String MASK = "^(?=.*[A-Z])" +
            "(?=.*[a-z])" +
            "(?=.*\\d)" +
            "(?=.*[!@#$%^&*])" +
            ".{8,20}$";
    private final static Pattern PATTERN = Pattern.compile(MASK);

    public static boolean isStrongPassword(String password) {
        return PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        String testPassword = "MyPass123!";
        System.out.println(testPassword + " -> " + isStrongPassword(testPassword));

        String testPassword1 = "weakpass";
        System.out.println(testPassword1 + " -> " + isStrongPassword(testPassword1));

        String testPassword2 = "NODIGITS!";
        System.out.println(testPassword2 + " -> " + isStrongPassword(testPassword2));

        String testPassword3 = "Short1!";
        System.out.println(testPassword3 + " -> " + isStrongPassword(testPassword3));

        String testPassword4 = "MoreThan20SymbolsPass!";
        System.out.println(testPassword4 + " -> " + isStrongPassword(testPassword4));

        String testPassword5 = "";
        System.out.println(testPassword5 + " -> " + isStrongPassword(testPassword5));
    }
}
