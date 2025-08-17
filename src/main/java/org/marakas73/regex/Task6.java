package org.marakas73.regex;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Задание 6
 * Создать метод, который извлекает все URL из текста. URL должен начинаться с http:// или https://.
 *
 * public List<String> extractUrls(String text) {
 *     // Ваш код здесь
 * }
 *
 * Примеры:
 *
 * "Посетите https://example.com и http://test.org" → ["https://example.com", "http://test.org"]
 * "Ссылка: https://domain.co.uk/path?param=value" → ["https://domain.co.uk/path?param=value"]
 */
public class Task6 {
    private final static String MASK = "https?://\\S+";
    private final static Pattern PATTERN = Pattern.compile(MASK);

    public static List<String> extractUrls(String text) {
        return PATTERN.matcher(text).results()
                .map(matchResult -> matchResult.group(0))
                .toList();
    }

    public static void main(String[] args) {
        String testText1 = "Посетите https://example.com и http://test.org";
        System.out.println(testText1 + " -> " + extractUrls(testText1));

        String testText2 = "Ссылка: https://domain.co.uk/path?param=value";
        System.out.println(testText2 + " -> " + extractUrls(testText2));

        String testText3 = "";
        System.out.println(testText3 + " -> " + extractUrls(testText3));
    }
}
