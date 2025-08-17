package org.marakas73.regex;

import java.util.regex.Pattern;

/**
 * Задание 2
 * Создать метод для валидации email адреса.
 * Email должен содержать латинские буквы, цифры, точки и дефисы в локальной части, символ @, и домен из букв и точек.
 *
 * public boolean isValidEmail(String email) {
 *     // Ваш код здесь
 * }
 *
 * Примеры:
 *
 * user@example.com → true
 * user.name@domain.co.uk → true
 * user@ → false
 * @domain.com → false
 */
public class Task2 {
    private final static String MASK = "^[a-zA-Z][A-Za-z0-9.-]*@[A-Za-z]+(?:\\.[A-Za-z]+)+$";
    private final static Pattern PATTERN = Pattern.compile(MASK);

    public static boolean isValidEmail(String email) {
        return PATTERN.matcher(email).matches();
    }

    public static void main(String[] args) {
        String testMail1 = "user@example.com";
        System.out.println(testMail1 + " -> " + isValidEmail(testMail1));

        String testMail2 = "user.name@domain.co.uk";
        System.out.println(testMail2 + " -> " + isValidEmail(testMail2));

        String testMail3 = "user@";
        System.out.println(testMail3 + " -> " + isValidEmail(testMail3));

        String testMail4 = "@domain.com";
        System.out.println(testMail4 + " -> " + isValidEmail(testMail4));

        String testMail5 = ".user@example.com";
        System.out.println(testMail5 + " -> " + isValidEmail(testMail5));

        String testMail6 = "";
        System.out.println(testMail6 + " -> " + isValidEmail(testMail6));
    }
}
