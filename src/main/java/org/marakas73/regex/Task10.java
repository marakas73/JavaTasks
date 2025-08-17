package org.marakas73.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Задание 10
 * Создать метод, который извлекает и валидирует JSON объекты из текста, используя только регулярные выражения. Нужно найти все JSON объекты и проверить базовую корректность структуры (парные скобки, кавычки для ключей).
 *
 * public List<String> extractValidJsonObjects(String text) {
 *     // Ваш код здесь
 * }
 *
 * Пример:
 *
 * Данные: {"name": "John", "age": 30} и {"invalid": json} и {"valid": "data", "number": 42}
 *
 * Должен вернуть: ["{"name": "John", "age": 30}", "{"valid": "data", "number": 42}"]
 */
public class Task10 {
    private final static String OBJECT_MASK = "\\{[^{}]*\\}";
    private final static Pattern OBJECT_PATTERN = Pattern.compile(OBJECT_MASK);
    private final static String PAIR_MASK = "\\s*\"[A-Za-z0-9_]+\"\\s*:\\s*(\"[^\"]*\"|-?\\d+(?:\\.\\d+)?)\\s*";
    private final static Pattern PAIR_PATTERN = Pattern.compile(PAIR_MASK);

    public static List<String> extractValidJsonObjects(String text) {
        List<String> result = new ArrayList<>();
        if (text == null || text.isEmpty()) return result;

        Matcher matcher = OBJECT_PATTERN.matcher(text);
        while (matcher.find()) {
            if (isValidSimpleJson(matcher.group())) {
                result.add(matcher.group());
            }
        }
        return result;
    }

    private static boolean isValidSimpleJson(String json) {
        if (json.length() < 2) return false;
        String inner = json.substring(1, json.length() - 1).trim();
        if (inner.isEmpty()) return true;

        String[] parts = inner.split("\\s*,\\s*");
        for (String part : parts) {
            if (!PAIR_PATTERN.matcher(part).matches()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String testText = "Данные: {\"name\": \"John\", \"age\": 30} и {\"invalid\": json} и {\"valid\": \"data\", \"number\": 42}";
        System.out.println(testText + "\n -> \n" + extractValidJsonObjects(testText));
    }
}
