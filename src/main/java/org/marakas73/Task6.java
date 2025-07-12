package org.marakas73;

import java.util.List;

/**
 * Работа с объектами
 * 6. Класс Person
 * Создайте класс Person с полями name (String) и age (int). Создайте список людей и найдите всех людей старше 18 лет.
 */
public class Task6 {
    private static List<Person> solve(List<Person> persons) {
        return persons.stream()
                .filter(person -> person.age > 18)
                .toList();
    }

    public static void main(String[] args) {
        List<Person> samplePersons = List.of(
                new Person("John", 10),
                new Person("Ben", 50),
                new Person("Max", 7),
                new Person("Tom", 19),
                new Person("Tim", 18),
                new Person("Alex", 27),
                new Person("Brad", 17)
        );

        solve(samplePersons).forEach(System.out::println);
    }

    private record Person(String name, int age) {}
}
