package org.example.data.service;

import org.example.data.entity.Person;
import org.example.data.entity.Product;
import org.example.data.entity.ProductStorage;
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


    public List<ProductStorage> getAll(){
        return productRepository.getProducts();
    }

    public List<ProductStorage> sortByPrice(Function fun){
        List<ProductStorage> products = new ArrayList<>();
        if(fun.equals(ASC))
            products =  productRepository.getProducts().stream().
                    sorted(Comparator.comparing(ProductStorage::getPriceByCount)).collect(Collectors.toList());

        if(fun.equals(DESC))
            products = productRepository.getProducts().stream()
                    .sorted(Comparator.comparing(ProductStorage::getPriceByCount, Comparator.reverseOrder()))
                    .toList();
        return products;
    }

    public double getAveragePrice(){
        return productRepository.getProducts().stream().mapToDouble(ProductStorage::getPriceByCount).average().orElse(0.00);
    }

    public void addProduct(ProductStorage product){
        productRepository.getProducts().add(product);
    }

    public void deleteProduct(ProductStorage product){
        if(productRepository.getProducts().contains(product))
            productRepository.getProducts().remove(product);
    }
    public void setProducts(List<ProductStorage> products){
        productRepository.setProducts(products);
    }
    public List<ProductStorage> getProductsStorage(){
        return productRepository.getProducts();
    }



}
