package org.marakas73.collections;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * ### 7. Проверка на анаграммы
 * Напишите метод, который проверяет, являются ли две строки анаграммами, используя Map для подсчета символов.
 *
 * java
 * public static boolean areAnagrams(String str1, String str2) {
 *     // Ваш код здесь
 * }
 */
public class Task7 {
    public static boolean areAnagrams(String str1, String str2) {
        if(str1.length() != str2.length()) return false; // Different length
        if(str1.equals(str2)) return false; // Equals strings are not anagrams

        var s1 = str1.toLowerCase(Locale.ROOT);
        var s2 = str2.toLowerCase(Locale.ROOT);

        Map<Character, Integer> letterOccurrences = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            letterOccurrences.put(
                    s1.charAt(i), letterOccurrences.getOrDefault(s1.charAt(i), 0) + 1
            );
            letterOccurrences.put(
                    s2.charAt(i), letterOccurrences.getOrDefault(s2.charAt(i), 0) - 1
            );
        }

        for(var occurrences : letterOccurrences.values()) {
            if(occurrences != 0) {
                return false; // Different letter occurrences
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("лАСка", "скаЛа"));
    }
}
