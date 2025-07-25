package org.marakas73.collections;

import java.util.*;

/**
 * ### 1. Удаление дубликатов из списка
 * Напишите метод, который принимает ArrayList<Integer> и возвращает новый список без дубликатов,
 * сохраняя порядок первого появления элементов.
 *
 * java
 * public static List<Integer> removeDuplicates(List<Integer> list) {
 *     // Ваш код здесь
 * }
 */
public class Task1 {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>(list);
        return new ArrayList<>(uniqueNumbers);
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers = List.of(
                12,7,5,12,9,3,7,4,5,8,2,9,6,1,3,8,2,6,10,1,4,7,10,9,5,6,3,2,8,1
        );

        System.out.println(removeDuplicates(sampleNumbers));
    }
}