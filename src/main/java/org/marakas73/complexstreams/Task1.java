package org.marakas73.complexstreams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. Дан список Sale с полями: productName, category, amount, date, salesPerson.
 * Найдите топ-3 категории по общей сумме продаж, исключив продажи менее 1000,
 * сгруппировав по категориям и отсортировав по убыванию суммы.
 * Результат должен содержать название категории и общую сумму.
 */
public class Task1 {
    private static final String[] PRODUCT_NAMES = {
            "Laptop", "Smartphone", "TV", "Bread", "Milk", "Sofa", "Shirt", "Pants",
            "Blender", "Headphones", "Pizza", "Apple", "Towel", "Desk", "Chair",
            "Sweater", "Monitor", "Camera", "Table", "Shoes"
    };

    private static final String[] PERSON_NAMES = {
            "Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hank", "Ivy", "Jack"
    };

    private static final Random RANDOM = new Random();

    private static List<Sale> generateSales(int count) {
        List<Sale> sales = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String productName = PRODUCT_NAMES[RANDOM.nextInt(PRODUCT_NAMES.length)];
            ProductCategory category = ProductCategory.values()[RANDOM.nextInt(ProductCategory.values().length)];
            long amount = RANDOM.nextInt(5001); // 0-5000
            LocalDate date = LocalDate.now().minusDays(RANDOM.nextInt(365));
            String personName = PERSON_NAMES[RANDOM.nextInt(PERSON_NAMES.length)];
            int age = 18 + RANDOM.nextInt(33); // 18-50

            Person salesPerson = new Person(personName, age);
            sales.add(new Sale(productName, category, amount, date, salesPerson));
        }

        return sales;
    }

    private static Map<ProductCategory, Long> solve(List<Sale> sales) {
        return sales.stream()
                .filter(sale -> sale.amount() >= 1000)
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(
                            Sale::category,
                            Sale::amount,
                            Long::sum
                        ),
                        groupedMap -> groupedMap.entrySet().stream()
                                .sorted(Map.Entry.<ProductCategory, Long>comparingByValue().reversed())
                                .limit(3)
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (v1, _) -> v1,
                                        LinkedHashMap::new
                                ))
                ));
    }

    public static void main(String[] args) {
        List<Sale> sampleSales = generateSales(30);

        System.out.println(solve(sampleSales));
    }

    private record Sale(
            String productName,
            ProductCategory category,
            long amount,
            LocalDate date,
            Person salesPerson
    ) {}

    private record Person(String name, int age) {}

    private enum ProductCategory {
        ELECTRONICS,
        FOOD,
        HOME_GOODS,
        FURNITURE,
        CLOTHING
    }
}
