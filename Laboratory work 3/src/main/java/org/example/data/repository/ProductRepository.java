package org.example.data.repository;

import lombok.Getter;
import lombok.Setter;
import org.example.data.entity.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductRepository {
    @Getter
    @Setter
    private List<Product> products = new ArrayList<>();

    private static ProductRepository instance;

    public static ProductRepository getInstance(){
        if(instance == null)
            instance = new ProductRepository();

        return instance;
    }

    private ProductRepository(){};
}
