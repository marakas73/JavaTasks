package org.marakas73.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ### 2. Подсчет частоты элементов
 * Создайте метод, который принимает список строк и возвращает Map<String, Integer> с
 * количеством вхождений каждой строки.
 *
 * java
 * public static Map<String, Integer> countFrequency(List<String> words) {
 *     // Ваш код здесь
 * }
 */
public class Task2 {
    public static Map<String, Integer> countFrequency(List<String> words) {
        Map<String, Integer> answerMap = new HashMap<>();
        for(var word : words) {
            answerMap.put(word, answerMap.getOrDefault(word, 0) + 1);
        }

        return answerMap;
    }

    public static void main(String[] args) {
        List<String> sampleWords = List.of("apple", "book", "car", "apple", "dog", "house", "car", "tree", "book", "sun", "moon", "tree", "cloud", "dog", "rain", "sky", "sun", "flower", "cloud", "bird", "sky", "chair", "flower", "table", "book", "chair", "moon", "rain", "apple", "table");

        System.out.println(countFrequency(sampleWords));
    }
}
