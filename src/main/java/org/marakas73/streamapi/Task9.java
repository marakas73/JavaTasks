package org.marakas73.streamapi;

import java.util.List;
import java.util.Objects;

/**
 * 9. Получение имен
 * Из списка объектов Person получите список только имен.
 */
public class Task9 {
    private static List<String> solve(List<Person> persons) {
        return persons.stream()
                .filter(person -> Objects.nonNull(person.name)) // Если null значения не допускаются
                .map(Person::name)
                .toList();
    }

    public static void main(String[] args) {
        List<Person> samplePersons = List.of(
                new Person("John", 10),
                new Person("Ben", 50),
                new Person("Max", 17),
                new Person(null, 19),
                new Person("Tim", 18),
                new Person("Chris", 18),
                new Person("Alex", 17),
                new Person(null, 17)
        );

        solve(samplePersons).forEach(System.out::println);
    }

    private record Person(String name, int age) {}
}
