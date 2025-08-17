package org.marakas73.regex;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Задание 8
 * Создать метод, который парсит лог-файл и извлекает IP адреса, временные метки и HTTP статус коды.
 * Формат лога: IP - - [timestamp] "METHOD /path HTTP/1.1" status size
 *
 * public class LogEntry {
 *     public String ip;
 *     public String timestamp;
 *     public int statusCode;
 * }
 *
 * public List<LogEntry> parseLogFile(String logContent) {
 *     // Ваш код здесь
 * }
 *
 * Пример лога:
 *
 * 192.168.1.1 - - [10/Oct/2023:13:55:36 +0000] "GET /index.html HTTP/1.1" 200 1234
 * 10.0.0.1 - - [10/Oct/2023:13:55:37 +0000] "POST /api/data HTTP/1.1" 404 567
 */
public class Task8 {
    private final static String GROUPED_MASK = "(\\d{1,3}(?:\\.\\d{1,3}){3})" + // ip
            "\\s-\\s-\\s" +
            "\\[(.+?)\\]" + // timestamp
            "\\s\"[^\"]+\"" + // method, path
            "\\s(\\d{3})"; // status code
    private final static Pattern PATTERN = Pattern.compile(GROUPED_MASK);

    public static List<LogEntry> parseLogFile(String logContent) {
        return PATTERN.matcher(logContent).results()
                .map(matchResult -> new LogEntry(
                        matchResult.group(1),
                        matchResult.group(2),
                        Integer.parseInt(matchResult.group(3))
                ))
                .toList();
    }

    public static void main(String[] args) {
        String testLog = "192.168.1.1 - - [10/Oct/2023:13:55:36 +0000] \"GET /index.html HTTP/1.1\" 200 1234\n" +
                "10.0.0.1 - - [10/Oct/2023:13:55:37 +0000] \"POST /api/data HTTP/1.1\" 404 567";
        System.out.println(testLog + " -> \n\n" + parseLogFile(testLog));
    }

    public record LogEntry (
        String ip,
        String timestamp,
        int statusCode
    ) {}
}
