package org.marakas73.streamapi;

import java.util.List;
import java.util.Objects;

/**
 * 15. Сложная фильтрация
 * Найдите всех людей, чье имя начинается с определенной буквы И возраст больше определенного значения.
 * (к примеру начинается с буквы Б и возраст больше 23)
 */
public class Task15 {
    private static List<Person> solve(List<Person> persons, char startNameLetter, int olderThan) {
        return persons.stream()
                .filter(person -> person.age > olderThan)
                .filter(person -> Objects.nonNull(person.name) && person.name.startsWith(String.valueOf(startNameLetter)))
                .toList();
    }

    public static void main(String[] args) {
        List<Person> samplePersons = List.of(
                new Person("John", 35),
                new Person("Daryl", 18),
                new Person("Dixon", 19),
                new Person("Max", 17),
                new Person(null, 19),
                new Person("Donny", 43),
                new Person("Chris", 18),
                new Person("Alex", 10),
                new Person(null, 17),
                new Person("Dilan", 5),
                new Person("Dan", 17),
                new Person("Dean", 56),
                new Person(null, 17)
        );

        solve(samplePersons, 'D', 18).forEach(System.out::println);
    }

    private record Person(String name, int age) {}
}
