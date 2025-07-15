package org.marakas73;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 26. Класс Product
 * Создайте класс Product с полями name, price, category. Найдите самый дорогой продукт в каждой категории.
 */
public class Task26 {
    private static Map<ProductCategory, Product> solve(List<Product> products) {
        return products.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        Product::category,
                        product -> product,
                        (p1, p2) -> p1.price() > p2.price() ? p1 : p2
                ));
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

        var resultMap = solve(sampleProducts);
        System.out.println(
                "Most expensive in " + ProductCategory.ELECTRONICS + ": " + resultMap.get(ProductCategory.ELECTRONICS)
        );
        System.out.println(
                "Most expensive in " + ProductCategory.FOOD + ": " + resultMap.get(ProductCategory.FOOD)
        );
        System.out.println(
                "Most expensive in " + ProductCategory.HOME_GOODS + ": " + resultMap.get(ProductCategory.HOME_GOODS)
        );
    }

    private record Product(String name, double price, ProductCategory category) {}

    private enum ProductCategory {
        ELECTRONICS,
        FOOD,
        HOME_GOODS
    }
}
