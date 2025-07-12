package org.marakas73;

import java.util.Comparator;
import java.util.List;

/**
 * 7. Сортировка людей по возрасту
 * Используя класс Person, отсортируйте список людей по возрасту в порядке возрастания.
 */
public class Task7 {
    private static List<Person> solve(List<Person> persons) {
        return persons.stream()
                .sorted(Comparator.comparing(person -> person.age))
                .toList();
    }

    public static void main(String[] args) {
        List<Person> samplePersons = List.of(
                new Person("John", 10),
                new Person("Ben", 50),
                new Person("Max", 7),
                new Person("Tom", 19),
                new Person("Tim", 18),
                new Person("Chris", 18),
                new Person("Alex", 27),
                new Person("Brad", 17)
        );

        solve(samplePersons).forEach(System.out::println);
    }

    private record Person(String name, int age) {}
}
