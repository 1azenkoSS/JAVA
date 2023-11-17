package org.example;

import org.example.data.entity.Order;
import org.example.data.entity.Person;
import org.example.data.entity.Product;
import org.example.data.service.FileService;
import org.example.data.service.OrderService;
import org.example.data.service.ProductService;
import org.example.enums.Category;
import org.example.enums.Function;

public class Main {
    private static FileService fileService = new FileService();
    private static ProductService productService = new ProductService();
    public static void main(String[] args) {
        String filePath = "src/main/resources/products.txt";
        fileService.readJsonFromFile(filePath);

        System.out.println(productService.getProductsStorage());
    }
}