package org.marakas73;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 8. Группировка по возрасту
 * Сгруппируйте людей по возрасту используя коллекторы.
 */
public class Task8 {
    private static Map<Integer, List<Person>> solve(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(person -> person.age));
    }

    public static void main(String[] args) {
        List<Person> samplePersons = List.of(
                new Person("John", 10),
                new Person("Ben", 50),
                new Person("Max", 17),
                new Person("Tom", 19),
                new Person("Tim", 18),
                new Person("Chris", 18),
                new Person("Alex", 17),
                new Person("Brad", 17)
        );

        solve(samplePersons).forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach(System.out::println);
        });
    }

    private record Person(String name, int age) {}
}
