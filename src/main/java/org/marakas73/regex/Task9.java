package org.marakas73.regex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Задание 9
 * Написать метод, который проверяет правильность написания HTML тегов в строке. Нужно проверить:
 *
 * Все открывающие теги имеют соответствующие закрывающие
 * Теги правильно вложены
 * Самозакрывающиеся теги корректны
 *
 * public boolean isValidHtml(String html) {
 *     // Ваш код здесь
 * }
 *
 * Примеры:
 *
 * "<div><p>Text</p></div>" → true
 * "<div><p>Text</div></p>" → false
 * "<img src='test.jpg' />" → true
 * "<div><span>Text</div>" → false
 */
public class Task9 {
    private final static String TAG_MASK = "<(/?)([a-zA-Z][a-zA-Z0-9]*)([^>]*)>"; // status code
    private final static Pattern TAG_PATTERN = Pattern.compile(TAG_MASK);

    public static boolean isValidHtml(String html) {
        Deque<String> stack = new ArrayDeque<>();
        Matcher matcher = TAG_PATTERN.matcher(html);

        while (matcher.find()) {
            String slash = matcher.group(1);
            String tagName = matcher.group(2);
            String rest = matcher.group(3).trim();

            boolean selfClosing = rest.endsWith("/");

            if (slash.isEmpty() && !selfClosing) {
                stack.push(tagName);
            } else if (!slash.isEmpty()) {
                if (stack.isEmpty() || !stack.peek().equals(tagName)) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String testHtml1 = "<div><p>Text</p></div>";
        System.out.println(testHtml1 + " -> " + isValidHtml(testHtml1));

        String testHtml2 = "<div><p>Text</div></p>";
        System.out.println(testHtml2 + " -> " + isValidHtml(testHtml2));

        String testHtml3 = "<img src='test.jpg' />";
        System.out.println(testHtml3 + " -> " + isValidHtml(testHtml3));

        String testHtml4 = "<div><span>Text</div>";
        System.out.println(testHtml4 + " -> " + isValidHtml(testHtml4));

        String testHtml5 = "";
        System.out.println(testHtml5 + " -> " + isValidHtml(testHtml5));
    }
}