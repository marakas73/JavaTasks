package org.marakas73;

import java.util.List;

/**
 * 5. Проверка условия для всех элементов
 * Проверьте, все ли числа в списке положительные
 */
public class Task5 {
    private static boolean solve(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number > 0);
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1);

        System.out.println(solve(sampleNumbers));
    }
}
