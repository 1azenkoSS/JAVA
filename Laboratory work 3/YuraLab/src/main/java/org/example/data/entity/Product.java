package org.example.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.data.service.ProductService;
import org.example.enums.Category;

@Data
@NoArgsConstructor
public class Product {

    private ProductStorage productStorage;
    private long count;
    private double sum;

    public Product(ProductStorage productStorage, long count){
        this.productStorage = productStorage;
        this.count = count;

        this.sum = count * productStorage.getPriceByCount();
    }


}
