package org.marakas73;

import java.util.List;
import java.util.Optional;

/**
 * 4. Поиск первого элемента
 * Найдите первое число в списке, которое больше 3
 */
public class Task4 {
    private static Optional<Integer> solve(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 3)
                .findFirst();
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        var numberOptional = solve(sampleNumbers);
        if(numberOptional.isPresent()) {
            System.out.println(numberOptional.get());
        } else {
            System.out.println("No number");
        }
    }
}
