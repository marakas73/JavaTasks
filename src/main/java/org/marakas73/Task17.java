package org.marakas73;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 17. Самая длинная строка
 * Найдите самую длинную строку в списке.
 */
public class Task17 {
    private static Optional<String> solve(List<String> stringList) {
        return stringList.stream()
                .max(Comparator.comparing(String::length));
    }

    public static void main(String[] args) {
        List<String> sampleStringList = List.of(
                "tiny",
                "more longer",
                "medium str",
                "same str",
                "same str",
                "longer",
                "same str",
                "most long string"
        );

        var optionalString = solve(sampleStringList);
        if(optionalString.isPresent()) {
            System.out.println(optionalString.get());
        } else {
            System.out.println("No strings provided");
        }
    }
}
