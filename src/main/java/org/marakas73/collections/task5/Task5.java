package org.marakas73.collections.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ### 5. Группировка студентов по оценкам
 * Создайте класс Student с полями name и grade. Напишите метод, который группирует список студентов по оценкам.
 *
 * java
 * class Student {
 *     private String name;
 *     private int grade;
 *
 *     // конструктор, геттеры, сеттеры
 * }
 *
 * public static Map<Integer, List<Student>> groupByGrade(List<Student> students) {
 *     // Ваш код здесь
 * }
 */
public class Task5 {
    public static Map<Integer, List<Student>> groupByGrade(List<Student> students) {
        Map<Integer, List<Student>> groupedStudents = new HashMap<>();
        for(var student : students) {
            var bufferList = groupedStudents.getOrDefault(student.getGrade(), new ArrayList<>());
            bufferList.add(student);

            groupedStudents.put(student.getGrade(), bufferList);
        }

        return groupedStudents;
    }

    public static void main(String[] args) {
        List<Student> sampleStudents = List.of(
                new Student("Ben", 10),
                new Student("Tom", 9),
                new Student("Chris", 9),
                new Student("Tim", 9),
                new Student("John", 5),
                new Student("Alex", 10),
                new Student("Irvin", 4)
        );

        System.out.println(groupByGrade(sampleStudents));
    }
}

