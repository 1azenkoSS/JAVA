package org.example.data.service;

import org.example.data.entity.Product;
import org.example.data.repository.ProductRepository;
import org.example.enums.Function;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.enums.Function.ASC;
import static org.example.enums.Function.DESC;

public class ProductService {

    private ProductRepository productRepository = ProductRepository.getInstance();


    public List<Product> getAll(){
        return productRepository.getProducts();
    }

    public List<Product> sortByPrice(Function fun){
        List<Product> products = new ArrayList<>();
        if(fun.equals(ASC))
            products =  productRepository.getProducts().stream().
                    sorted(Comparator.comparing(Product::getPriceByCount)).collect(Collectors.toList());

        if(fun.equals(DESC))
            products = productRepository.getProducts().stream()
                    .sorted(Comparator.comparing(Product::getPriceByCount, Comparator.reverseOrder()))
                    .toList();
        return products;
    }

    public double getAveragePrice(){
        return productRepository.getProducts().stream().mapToDouble(Product::getPriceByCount).average().orElse(0.00);
    }

    public void addProduct(Product product){
        productRepository.getProducts().add(product);
    }

    public void deleteProduct(Product product){
        if(productRepository.getProducts().contains(product))
            productRepository.getProducts().remove(product);
    }
    public void setProducts(List<Product> products){
        productRepository.setProducts(products);
    }
    public List<Product> getProductsStorage(){
        return productRepository.getProducts();
    }



}
