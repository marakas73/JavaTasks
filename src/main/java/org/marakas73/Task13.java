package org.marakas73;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 13. Сбор в Map
 * Создайте Map, где ключ - это имя человека, а значение - его возраст, из списка объектов Person.
 */
public class Task13 {
    private static Map<String, Integer> solve(List<Person> persons) {
        return persons.stream()
                .filter(person -> Objects.nonNull(person.name))
                .collect(Collectors.toMap(person -> person.name, Person::age));
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

        solve(samplePersons).forEach((key, value) -> System.out.println(key + ":" + value));
    }

    private record Person(String name, int age) {}
}
