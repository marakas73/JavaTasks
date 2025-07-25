package org.marakas73.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 29. Сложная группировка
 * Сгруппируйте людей сначала по возрасту (взрослые/дети), а затем по первой букве имени.
 */
public class Task29 {
    private final static String ADULTS_KEYNAME = "adults";
    private final static String CHILDREN_KEYNAME = "children";

    private static Map<String, Map<Character, List<Person>>> solve(List<Person> persons) {
        return persons.stream()
                .filter(person -> Objects.nonNull(person) && Objects.nonNull(person.name()))
                .collect(Collectors.groupingBy(
                        person -> person.age() < 18 ? CHILDREN_KEYNAME : ADULTS_KEYNAME,
                        Collectors.groupingBy(subPerson -> subPerson.name().charAt(0)))
                );
    }

    public static void main(String[] args) {
        List<Person> samplePersons = Arrays.asList(
                null,
                new Person("John", 35),
                new Person("Daryl", 18),
                new Person("Dixon", 19),
                new Person("Max", 17),
                null,
                new Person(null, 19),
                new Person("Donny", 43),
                new Person("Chris", 18),
                new Person("Alex", 10),
                null,
                null,
                new Person(null, 17),
                new Person("Dilan", 5),
                new Person("Dan", 17),
                new Person("Dean", 56),
                new Person(null, 17)
        );

        var groupedPersons = solve(samplePersons);

        printLetterGroupedPersons(CHILDREN_KEYNAME, groupedPersons.get(CHILDREN_KEYNAME));
        printLetterGroupedPersons(ADULTS_KEYNAME, groupedPersons.get(ADULTS_KEYNAME));
    }

    private static void printLetterGroupedPersons(String group, Map<Character, List<Person>> groupedPersons) {
        System.out.println(group + ":");
        groupedPersons.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach(person -> System.out.println("\t" + person));
        });
    }

    private record Person(String name, int age) {
        @Override
        public String toString() {
            return name + " - " + age;
        }
    }
}
