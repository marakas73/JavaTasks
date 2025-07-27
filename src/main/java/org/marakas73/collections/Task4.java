package org.marakas73.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * ### 4. Поиск пересечения множеств
 * Напишите метод, который находит общие элементы в двух множествах и возвращает их в виде нового множества.
 *
 * java
 * public static Set<String> findIntersection(Set<String> set1, Set<String> set2) {
 *     // Ваш код здесь
 * }
 */
public class Task4 {
    public static Set<String> findIntersection(Set<String> set1, Set<String> set2) {
        var smallerSet = set1.size() < set2.size() ? set1 : set2;
        var biggerSet = set1.size() < set2.size() ? set2 : set1;

        var bufferSet = new HashSet<>(smallerSet);
        bufferSet.retainAll(biggerSet);
        return bufferSet;
    }

    public static void main(String[] args) {
        Set<String> sampleNumberSet1 = Set.of(
                "apple",
                "banana",
                "pear",
                "melon",
                "blueberries",
                "strawberries"
        );
        Set<String> sampleNumberSet2 = Set.of(
                "pineapple",
                "coconut",
                "banana",
                "peach",
                "mango",
                "melon",
                "strawberries"
        );

        System.out.println(sampleNumberSet1);
        System.out.println(sampleNumberSet2);
        System.out.println(findIntersection(sampleNumberSet1, sampleNumberSet2));
    }
}
