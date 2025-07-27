package org.marakas73.collections;

import org.marakas73.collections.task5.Student;

import java.util.*;

/**
 * ### 6. Поворот списка
 * Реализуйте метод, который поворачивает
 * список на k позиций влево. Например, [1,2,3,4,5] с k=2 становится [3,4,5,1,2].
 *
 * java
 * public static void rotateLeft(List<Integer> list, int k) {
 *     // Ваш код здесь
 * }
 */
public class Task6 {
    public static void rotateLeft(List<Integer> list, int k) {
        if(list.isEmpty()) return;

        k %= list.size();
        if(k == 0) return;

        // Get new values list
        var bufferList = new ArrayList<>(list.subList(k, list.size()));
        for(int i = 0; i < k; i++) {
            bufferList.add(list.get(i));
        }

        // Set new values for provided list
        for(int i = 0; i < list.size(); i++) {
            list.set(i, bufferList.get(i));
        }
    }

    public static void main(String[] args) {
        List<Integer> sampleList = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(sampleList);
        rotateLeft(sampleList, 2);
        System.out.println(sampleList);
    }
}
