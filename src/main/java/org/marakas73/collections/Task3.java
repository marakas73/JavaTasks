package org.marakas73.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * ### 3. Объединение двух отсортированных списков
 * Реализуйте метод для слияния двух отсортированных списков
 * в один отсортированный список без использования Collections.sort().
 *
 * java
 * public static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
 *     // Ваш код здесь
 * }
 */
public class Task3 {
    public static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        if(list1.isEmpty()) return new ArrayList<>(list2);
        if(list2.isEmpty()) return new ArrayList<>(list1);

        int totalSize = list1.size() + list2.size();
        List<Integer> answerList = new ArrayList<>(totalSize);

        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0; i < totalSize; i++) {
            if(list1.get(idx1) <= list2.get(idx2)) {
                answerList.add(list1.get(idx1++));
                if(idx1 >= list1.size()) {
                    while(idx2 < list2.size()) {
                        answerList.add(list2.get(idx2++));
                    }
                    break;
                }
            } else {
                answerList.add(list2.get(idx2++));
                if(idx2 >= list2.size()) {
                    while(idx1 < list1.size()) {
                        answerList.add(list1.get(idx1++));
                    }
                    break;
                }
            }
        }

        return answerList;
    }

    public static void main(String[] args) {
        List<Integer> sampleNumbers1 = List.of(8, 5, 11, 7, 5, 10, 53);
        List<Integer> sampleNumbers2 = List.of(7, 2, 0, 75, 61, 4, 9, 1, 2, 6);

        var sortedList1 = sampleNumbers1.stream().sorted().toList();
        var sortedList2 = sampleNumbers2.stream().sorted().toList();

        System.out.println(sortedList1);
        System.out.println(sortedList2);
        System.out.println(mergeSortedLists(sortedList1, sortedList2));
    }
}
