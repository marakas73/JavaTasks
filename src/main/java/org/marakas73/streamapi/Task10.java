package org.marakas73.streamapi;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 10. Средний возраст
 * Вычислите средний возраст всех людей в списке.
 */
public class Task10 {
    private static double solve(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.averagingInt(person -> person.age));
    }

    public static void main(String[] args) {
        List<Person> samplePersons = List.of(
                new Person("John", 27),
                new Person("Ben", 15),
                new Person("Max", 17),
                new Person(null, 19),
                new Person("Tim", 63),
                new Person("Chris", 18),
                new Person("Alex", 17),
                new Person(null, 5)
        );

        System.out.println(solve(samplePersons));
    }

    private record Person(String name, int age) {}
}
