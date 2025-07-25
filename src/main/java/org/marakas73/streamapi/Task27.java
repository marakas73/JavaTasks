package org.marakas73.streamapi;

import java.util.*;

/**
 * 27. Топ-N элементов
 * Найдите N самых дорогих продуктов, отсортированных по убыванию цены.
 */
public class Task27 {
    private static List<Product> solve(List<Product> products, int n) {
        return products.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(Product::price).reversed())
                .limit(n)
                .toList();
    }

    public static void main(String[] args) {
        List<Product> sampleProducts = Arrays.asList(
                new Product("Laptop", 999.99, ProductCategory.ELECTRONICS),
                new Product("Same price Laptop", 999.99, ProductCategory.ELECTRONICS),
                new Product("Smartphone", 699.99, ProductCategory.ELECTRONICS),
                new Product("Headphones", 149.99, ProductCategory.ELECTRONICS),
                null,
                new Product("Tablet", 499.99, ProductCategory.ELECTRONICS),
                new Product("Smartwatch", 249.99, ProductCategory.ELECTRONICS),
                new Product("Bread", 2.99, ProductCategory.FOOD),
                new Product("Apples", 3.99, ProductCategory.FOOD),
                new Product("Sofa", 799.99, ProductCategory.HOME_GOODS),
                new Product("Coffee Table", 199.99, ProductCategory.HOME_GOODS),
                new Product("Bed Sheets", 49.99, ProductCategory.HOME_GOODS),
                null,
                null,
                null,
                new Product("Lamp", 39.99, ProductCategory.HOME_GOODS),
                new Product("Pasta", 1.99, ProductCategory.FOOD),
                new Product("Olive Oil", 7.99, ProductCategory.FOOD),
                new Product("Pillow", 19.99, ProductCategory.HOME_GOODS),
                new Product("Rug", 129.99, ProductCategory.HOME_GOODS),
                null
        );

        solve(sampleProducts, 10).forEach(System.out::println);
    }

    private record Product(String name, double price, ProductCategory category) {}

    private enum ProductCategory {
        ELECTRONICS,
        FOOD,
        HOME_GOODS
    }
}
