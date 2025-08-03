package org.marakas73.complexstreams;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2. Дан список строк логов в формате: "2024-01-15 ERROR UserService: User not found".
 * Извлеките все уникальные сервисы, которые генерировали ошибки ERROR в определенный день,
 * отсортируйте по алфавиту и преобразуйте в строку через запятую.
 */
public class Task2 {
    private static final Pattern errorPattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2} ERROR .+$");
    private static final Pattern serviceNamePattern = Pattern.compile("\\b([A-Z][a-zA-Z0-9]+Service)\\b");

    public static List<String> extractServices(List<String> logs) {
        return logs.stream()
                .filter(errorPattern.asPredicate())
                .map(serviceNamePattern::matcher)
                .filter(Matcher::find)
                .map(matcher -> matcher.group(0))
                .distinct()
                .sorted()
                .toList();
    }

    public static void main(String[] args) {
        List<String> sampleLogs = List.of(
                "2024-01-15 ERROR UserService: User not found",
                "2024-01-15 INFO AuthService: User logged in",
                "2024-01-15 ERROR NotificationService: Email delivery failed",
                "2024-01-16 WARN PaymentService: Payment delayed",
                "2024-01-15 ERROR AuthService: Token expired",
                "2024-01-17 DEBUG ReportService: Report generation started",
                "2024-01-15 ERROR CacheService: Cache miss for key user_123",
                "2024-01-18 INFO UserService: Profile updated",
                "2024-01-15 ERROR AnalyticsService: Data pipeline broken",
                "2024-01-15 ERROR SearchService: Indexing failed"
        );

        System.out.println(extractServices(sampleLogs));
    }
}
